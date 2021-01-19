package org.BG.Service.login;

import org.BG.DAO.LoginDao;
import org.BG.DTO.AdminDto;
import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.BG.util.ScrapingTaxTypeFromNts;
import org.BG.util.geocoder.Geocoder;
import org.BG.util.mail.Mail;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    LoginDao loginDao;
    @Autowired
    Mail mail;
    @Autowired
    ScrapingTaxTypeFromNts scrapingTaxTypeFromNts;
    @Autowired
    Aws_Cdn_Service aws_cdn_service;
    @Autowired
    Geocoder geocoder;

    @Override
    public String appLogin(UserDto userDto) {
        try {
            return loginDao.appLogin(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appSendCodeOfRegister(RegisterDto registerDto) {
        try {
            //인증코드 생성
            registerDto.setRegister_Code(makeEmailCode());

            //인증코드 전송
            //mail.mailSender(송신자의 아이디, 송신자의 비밀번호, 수신자 이메일, 메일 내용, 인증코드)
            mail.MailSender("ehdrbdndns@naver.com", "100400sw@", registerDto.getRegister_Email(), "이메일 인증코드 테스트입니다.", registerDto.getRegister_Code());

            //현재 날짜 셋팅
            registerDto.setRegister_RegDate(getToday());

            //User_No or err 반환
            return loginDao.appSendCodeOfRegister(registerDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appConfirmCodeOfRegister(RegisterDto registerDto) {
        try {
            return loginDao.appConfirmCodeOfRegister(registerDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appConfirmBusinessNumberOfRegister(UserDto userDto) {
        try {
            if(adminCheckLicenseNumber(userDto.getUser_ComNo())){
                List<String> listBusinessRegNo = new ArrayList<>();
                listBusinessRegNo.add(userDto.getUser_ComNo());

                List<Map<String, String>> listResult = scrapingTaxTypeFromNts.selectTaxTypeFromNts(listBusinessRegNo);
                String result = "";
                for (String businessRegNo : listBusinessRegNo) {
                    String value = listResult.stream().filter(map -> map.containsKey(businessRegNo)).map(map -> map.get(businessRegNo)).collect(Collectors.joining());
                    result = value;
                }
                return result;
            } else{
                return "사업을 하지 않고 있습니다.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appRegister(UserDto userDto) throws IOException {
        try{
            //위도 경도 설정
            Double[] coords = geocoder.getLatitude(userDto.getUser_Addr());
            if(coords == null){
                return "geocoder_Err";
            }
            userDto.setUser_Lat(coords[0]);
            userDto.setUser_Lng(coords[1]);

            userDto.setUser_RegDate(getToday());
            //사용자 등록 후 key 반환
            String user_No = loginDao.appRegister(userDto);
            userDto.setUser_No(Integer.parseInt(user_No));
            //반환된 key를 사용해 고유 파일 경로를 만들고 사업자 등록증을 업로드
            String user_ComImg = aws_cdn_service.FileUpload("user/"+user_No+"/comImg/", userDto.getUser_ComImg_File());
            //사업자 등록증의 파일 경로를 db에 삽입입
            userDto.setUser_ComImg(user_ComImg);
            return loginDao.appRegisterOfComImg(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appSearchEmail(UserDto userDto) {
        try{
            return loginDao.appSearchEmail(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appSendCodeOfSearch(RegisterDto registerDto) {
        try{
            return loginDao.appSendCodeOfSearch(registerDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appChangePwd(UserDto userDto) {
        try{
            return loginDao.appChangePwd(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/login.do")
    public String loginPage() {
        return "login/login";
    }

    @Override
    public boolean adminLogin(String id, String pwd) {
        try{
            AdminDto adminDto = loginDao.adminLogin();
            if(adminDto.getId().equals(id) && adminDto.getPwd().equals(pwd)){
                return true;
            } else{
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String appCheckUserState(UserDto userDto) {
        try{
            //0: 벤, 1: 노벤
            int check = loginDao.appCheckUserState(userDto);
            if(check == 1)
                return "true";
            else
                return "false";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int isExistComNo(UserDto userDto) {
        return loginDao.isExistComNo(userDto);
    }

    public String makeEmailCode() {
        StringBuffer ConfirmCode = new StringBuffer();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
                case 0:
                    // a-z
                    ConfirmCode.append((char) ((int) (rnd.nextInt(26)) + 97));
                    break;
                case 1:
                    // A-Z
                    ConfirmCode.append((char) ((int) (rnd.nextInt(26)) + 65));
                    break;
                case 2:
                    // 0-9
                    ConfirmCode.append((rnd.nextInt(10)));
                    break;
            }
        }
        return ConfirmCode.toString();
    }

    //사업자 등록 번호 유효성 체크
    private final static int[] LOGIC_NUM = {1, 3, 7, 1, 3, 7, 1, 3, 5, 1};

    public boolean adminCheckLicenseNumber(String licenseNumber) {
        licenseNumber = licenseNumber.replaceAll("-", "");
        boolean result = isValid(licenseNumber);
        System.out.println("유효성 검사 : " + result);
        return result;
    }

    public boolean isValid(String regNum) {

        if (!isNumeric(regNum) || regNum.length() != 10)
            return false;

        int sum = 0;
        int j = -1;
        for (int i = 0; i < 9; i++) {
            j = Character.getNumericValue(regNum.charAt(i));
            sum += j * LOGIC_NUM[i];
        }

        sum += (int) (Character.getNumericValue(regNum.charAt(8)) * 5 / 10);

        int checkNum = (10 - sum % 10) % 10;
        return (checkNum == Character.getNumericValue(regNum.charAt(9)));
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}

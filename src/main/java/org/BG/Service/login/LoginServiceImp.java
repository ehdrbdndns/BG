package org.BG.Service.login;

import org.BG.DAO.LoginDao;
import org.BG.DAO.UserDao;
import org.BG.DTO.AdminDto;
import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.BG.util.Pwd.PwdToByte;
import org.BG.util.ScrapingTaxTypeFromNts;
import org.BG.util.geocoder.Geocoder;
import org.BG.util.geocoder.GpsToAddress;
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
    UserDao userDao;
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
            //사용자 비밀번호 암호화
            PwdToByte pwdToByte = new PwdToByte();
            String pwd = pwdToByte.encryptionSHA256(userDto.getUser_PW());
            System.out.println("로그인 암호화 비밀번호: " + pwd);
            userDto.setUser_PW(pwd);

            return loginDao.appLogin(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appSendCodeOfRegister(RegisterDto registerDto) {
        try {

            Integer check = loginDao.appIsExistUserEmail(registerDto);
            if(check == null || check == 0){
                //인증코드 생성
                registerDto.setRegister_Code(makeEmailCode());

                //인증코드 전송
                //mail.mailSender(송신자의 아이디, 송신자의 비밀번호, 수신자 이메일, 메일 내용, 인증코드)
                mail.MailSender("airlkh@naver.com", "19912096lkh!@)", registerDto.getRegister_Email(), "바꿔먹어 인증번호입니다.", registerDto.getRegister_Code());

                //현재 날짜 셋팅
                registerDto.setRegister_RegDate(getToday());

                //User_No or err 반환
                return loginDao.appSendCodeOfRegister(registerDto);
            } else{
                return null;
            }
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

            //사용자 주소 카운팅
            addStoreCount(userDto.getUser_Lat(), userDto.getUser_Lng());

            //사용자 비밀번호 암호화화
            PwdToByte pwdToByte = new PwdToByte();
            String pwd = pwdToByte.encryptionSHA256(userDto.getUser_PW());
            System.out.println("가입자 암호화된 비밀번호: " + pwd);
            userDto.setUser_PW(pwd);

            userDto.setUser_RegDate(getToday());

            //사업자 등록번호 재조정
            String comNo = userDto.getUser_ComNo().replaceAll("-", "");
            userDto.setUser_ComNo(comNo);

            //사용자 등록 후 key 반환
            String user_No = loginDao.appRegister(userDto);
            userDto.setUser_No(Integer.parseInt(user_No));

            //반환된 key를 사용해 고유 파일 경로를 만들고 사업자 등록증을 업로드
//            String user_ComImg = aws_cdn_service.FileUpload("user/"+user_No+"/comImg/", userDto.getUser_ComImg_File());
            //사업자 등록증의 파일 경로를 db에 삽입입
            userDto.setUser_ComImg("default");
            return loginDao.appRegisterOfComImg(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appSearchEmail(UserDto userDto) {
        try{
            String comNo = userDto.getUser_ComNo().replaceAll("-", "");
            userDto.setUser_ComNo(comNo);
            return loginDao.appSearchEmail(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appSendCodeOfSearch(RegisterDto registerDto) {
        try{
            //인증코드 생성
            registerDto.setRegister_Code(makeEmailCode());

            //인증코드 전송
            //mail.mailSender(송신자의 아이디, 송신자의 비밀번호, 수신자 이메일, 메일 내용, 인증코드)
            mail.MailSender("airlkh@naver.com", "19912096lkh!@)", registerDto.getRegister_Email(), "바꿔먹어 인증번호입니다. ", registerDto.getRegister_Code());

            //현재 날짜 셋팅
            registerDto.setRegister_RegDate(getToday());

            return loginDao.appSendCodeOfSearch(registerDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appChangePwd(UserDto userDto) {
        try{
            PwdToByte pwdToByte = new PwdToByte();
            String pwd = pwdToByte.encryptionSHA256(userDto.getUser_PW());
            userDto.setUser_PW(pwd);
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

    public void addStoreCount(Double lat, Double lng){
        try{
            GpsToAddress gpsToAddress = new GpsToAddress(lat, lng);
            String address = gpsToAddress.getAddress();

            System.out.println("가입자 지역 카운트 주소: " + address);

            String title = "none";
            if(address.contains("서울")){
                title = "Seoul";
            } else if(address.contains("경기도")){
                title = "Gyeonggi";
            } else if(address.contains("강원도")){
                title = "Gangwon";
            } else if(address.contains("충청북도")){
                title = "Chungcheongbuk";
            }  else if(address.contains("충청남도")){
                title = "Chungcheongnam";
            } else if(address.contains("전라북도")){
                title = "Jeollabuk";
            } else if(address.contains("전라남도")){
                title = "Jeollanam";
            } else if(address.contains("경상북도")){
                title = "Gyeongsangbuk";
            } else if(address.contains("경상남도")){
                title = "Gyeongsangnam";
            } else if(address.contains("제주")){
                title = "Jeju";
            } else if(address.contains("부산")){
                title = "Busan";
            }else if(address.contains("대구")){
                title = "Daegu";
            }else if(address.contains("인천")){
                title = "Incheon";
            }else if(address.contains("광주")){
                title = "Gwangju";
            }else if(address.contains("대전")){
                title = "Daejeon";
            }else if(address.contains("울산")){
                title = "Ulsan";
            }else{
                System.out.println("해당 지역이 없습니다 address: " + address);
            }

            if(!title.equals("none")){
                userDao.addStoreCount(title);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("storeCount err");
        }
    }

    public String makeEmailCode() {
        return Integer.toString((int) (Math.random()*999999) + 100000);
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

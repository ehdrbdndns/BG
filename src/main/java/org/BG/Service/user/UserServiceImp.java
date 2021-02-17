package org.BG.Service.user;

import org.BG.DAO.UserDao;
import org.BG.DTO.StoreCountDto;
import org.BG.DTO.UserDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.BG.util.Pwd.PwdToByte;
import org.BG.util.geocoder.Geocoder;
import org.BG.util.geocoder.GpsToAddress;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    Aws_Cdn_Service aws_cdn_service;
    @Autowired
    Geocoder geocoder;

    @Override
    public JSONObject appRetrieveUserInfo(UserDto userDto) {
        JSONObject result = new JSONObject();
        try {
            UserDto userDto1 = userDao.appRetrieveUserInfo(userDto);
            if(userDto1.getStore_Img().equals("")){
                userDto1.setStore_Img("default");
            }
            result.put("profileImg", userDto1.getStore_Img());
            result.put("storeName", userDto1.getUser_ComNm());
            result.put("address", userDto1.getUser_Addr());
            result.put("phone", userDto1.getUser_Phone());
            result.put("detailAddress", userDto1.getUser_Details());
            result.put("userName", userDto1.getUser_Name());

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appModifyUserInfo(UserDto userDto) throws IOException {
        try {
            //위도 경도 설정
            Double[] coords = geocoder.getLatitude(userDto.getUser_Addr());
            if (coords == null) {
                return "geocoder_Err";
            }
            userDto.setUser_Lat(coords[0]);
            userDto.setUser_Lng(coords[1]);

            UserDto userInfo = userDao.appRetrieveUserInfo(userDto);
            //사용자 주소 카운팅
            //기존 주소
            minusStoreCount(userInfo.getUser_Lat(), userInfo.getUser_Lng());
            //새로운 주소
            addStoreCount(userDto.getUser_Lat(), userDto.getUser_Lng());

            String store_Img;
            if (userDto.getStore_Img_File() != null) {
                aws_cdn_service.FileDelete("user/" + userDto.getUser_No() + "/store/storeImg");
                store_Img = aws_cdn_service.FileUpload("user/" + userDto.getUser_No() + "/store/storeImg/", userDto.getStore_Img_File());
            } else {
                store_Img = userInfo.getStore_Img();
            }
            userDto.setStore_Img(store_Img);
            return userDao.appModifyUserInfo(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appModifyUserAlarm(UserDto userDto) {
        try {
            userDao.appModifyUserAlarm(userDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject appRetrieveUserAlarm(UserDto userDto) {
        JSONObject result = new JSONObject();
        try {
            UserDto userDto1 = userDao.appRetrieveUserAlarm(userDto);
            result.put("alarm1", userDto1.getUser_Alarm1());
            result.put("alarm2", userDto1.getUser_Alarm2());
            result.put("alarm3", userDto1.getUser_Alarm3());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<UserDto> getUserList() {
        try {
            return userDao.getUserList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserDto getUserInfo(UserDto userDto) {
        try {
            return userDao.getUserInfo(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject getUserAreaCount() {
        JSONObject result = new JSONObject();
        try {
            result.put("경기도", userDao.getUserAreaCount("%경기도%"));
            result.put("강원도", userDao.getUserAreaCount("%강원도%"));
            result.put("충청북도", userDao.getUserAreaCount("%충청북도%"));
            result.put("충청남도", userDao.getUserAreaCount("%충청남도%"));
            result.put("경상북도", userDao.getUserAreaCount("%경상북도%"));
            result.put("경상남도", userDao.getUserAreaCount("%경상남도%"));
            result.put("전라북도", userDao.getUserAreaCount("%전라북도%"));
            result.put("전라남도", userDao.getUserAreaCount("%전라남도%"));
            result.put("제주도", userDao.getUserAreaCount("%제주도%"));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<UserDto> getBlackList() {
        return userDao.getBlackList();
    }

    @Override
    public ArrayList<UserDto> getUnBlackList() {
        return userDao.getUnBlackList();
    }

    @Override
    public void modifyUserState(UserDto userDto) {
        userDao.modifyUserState(userDto);
    }

    @Override
    public String appCheckVersion() {
        return userDao.appCheckVersion();
    }

    @Override
    public void updateVersion(String version) {
        userDao.updateVersion(version);
    }

    @Override
    public StoreCountDto getStoreCount() {
        return userDao.getStoreCount();
    }

    @Override
    public String appDeleteUserInfo(UserDto userDto) throws Exception {
        UserDto userInfo = userDao.appRetrieveUserInfo(userDto);
        PwdToByte pwdToByte = new PwdToByte();
        userDto.setUser_PW(pwdToByte.encryptionSHA256(userDto.getUser_PW()));
        if(userInfo.getUser_PW().equals(userDto.getUser_PW())){
            System.out.println("회원탈퇴 : " + userDto.getUser_Name());
            userDao.deleteUserInfo(userDto);
            return "true";
        } else{
            System.out.println("회원탈퇴 실패 비밀번호 틀림");
            return "false";
        }
    }

    @Override
    public String testDeleteUserInfo(UserDto userDto) throws Exception {
        UserDto userInfo = userDao.appRetrieveUserInfo(userDto);
        PwdToByte pwdToByte = new PwdToByte();
        userDto.setUser_PW(pwdToByte.encryptionSHA256(userDto.getUser_PW()));
        if(userInfo.getUser_PW().equals(userDto.getUser_PW())){
            System.out.println("회원탈퇴 : " + userDto.getUser_Name());
            return "true";
        } else{
            System.out.println("회원탈퇴 실패 비밀번호 틀림");
            return "false";
        }
    }

    @Override
    public void updateUserPwd(UserDto userDto) throws NoSuchAlgorithmException {
        PwdToByte pwdToByte = new PwdToByte();
        String pwd = pwdToByte.encryptionSHA256(userDto.getUser_PW());
        System.out.println("기존 유저 번호: "+ userDto.getUser_No() + ", 이름: " + userDto.getUser_Name() + ", 기존 비밀번호: " + userDto.getUser_PW() + ", 변경된 비밀번호: " + pwd);
        userDto.setUser_PW(pwd);
        userDao.updateUserPwd(userDto);
    }

    @Override
    public ArrayList<UserDto> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public UserDto searchUser(int userNo) {
        return userDao.searchUser(userNo);
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

    public void minusStoreCount(Double lat, Double lng){
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
                userDao.minusStoreCount(title);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("storeCount err");
        }
    }
}

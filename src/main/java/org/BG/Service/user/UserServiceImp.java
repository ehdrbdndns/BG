package org.BG.Service.user;

import org.BG.DAO.UserDao;
import org.BG.DTO.UserDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.BG.util.geocoder.Geocoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

            String store_Img;
            if (userDto.getStore_Img_File() != null) {
                aws_cdn_service.FileDelete("user/" + userDto.getUser_No() + "/store/storeImg");
                store_Img = aws_cdn_service.FileUpload("user/" + userDto.getUser_No() + "/store/storeImg/", userDto.getStore_Img_File());
            } else {
                UserDto userInfo = userDao.appRetrieveUserInfo(userDto);
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
}

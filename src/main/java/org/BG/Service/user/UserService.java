package org.BG.Service.user;

import org.BG.DTO.ShopinDto;
import org.BG.DTO.StoreCountDto;
import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public interface UserService {
    JSONObject appRetrieveUserInfo(UserDto userDto);
    String appModifyUserInfo(UserDto userDto) throws IOException;
    String appModifyUserAlarm(UserDto userDto);
    JSONObject appRetrieveUserAlarm(UserDto userDto);
    ArrayList<UserDto> getUserList();
    UserDto getUserInfo(UserDto userDto);
    JSONObject getUserAreaCount();
    ArrayList<UserDto> getBlackList();
    ArrayList<UserDto> getUnBlackList();
    void modifyUserState(UserDto userDto);
    String appCheckVersion();
    void updateVersion(String version);
    StoreCountDto getStoreCount();
    String appDeleteUserInfo(UserDto userDto, HttpServletRequest request) throws Exception;
    String testDeleteUserInfo(UserDto userDto, HttpServletRequest request) throws Exception;
    void updateUserPwd(UserDto userDto) throws NoSuchAlgorithmException;
    ArrayList<UserDto> getAllUser();
    UserDto searchUser(int userNo);
}

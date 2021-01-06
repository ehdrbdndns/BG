package org.BG.Service.user;

import org.BG.DTO.ShopinDto;
import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public interface UserService {
    JSONObject appRetrieveUserInfo(UserDto userDto);
    String appModifyUserInfo(UserDto userDto) throws IOException;
    String appModifyUserAlarm(UserDto userDto);
    JSONObject appRetrieveUserAlarm(UserDto userDto);
    ArrayList<UserDto> getUserList();
    UserDto getUserInfo(UserDto userDto);
}

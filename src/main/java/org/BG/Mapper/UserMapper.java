package org.BG.Mapper;

import org.BG.DTO.UserDto;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {
    UserDto appRetrieveUserInfo(UserDto userDto);
    void appModifyUserInfo(UserDto userDto);
    void appModifyUserAlarm(UserDto userDto);
    UserDto appRetrieveUserAlarm(UserDto userDto);
    ArrayList<UserDto> getUserList();
    UserDto getUserInfo(UserDto userDto);
    String RetrieveUserFcm(int user_No);
    List<String> getUserFcm();
    int getUserAreaCount(String area);
    ArrayList<UserDto> getBlackList();
    ArrayList<UserDto> getUnBlackList();
    void modifyUserState(UserDto userDto);
    int isExistComNo(UserDto userDto);
    String appCheckVersion();
    void updateVersion(String version);
}

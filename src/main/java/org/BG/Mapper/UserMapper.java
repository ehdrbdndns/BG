package org.BG.Mapper;

import org.BG.DTO.UserDto;

import java.util.ArrayList;

public interface UserMapper {
    UserDto appRetrieveUserInfo(UserDto userDto);
    void appModifyUserInfo(UserDto userDto);
    void appModifyUserAlarm(UserDto userDto);
    UserDto appRetrieveUserAlarm(UserDto userDto);
    ArrayList<UserDto> getUserList();
    UserDto getUserInfo(UserDto userDto);
}

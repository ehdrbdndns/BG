package org.BG.Mapper;

import org.BG.DTO.StoreCountDto;
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
    void addStoreCount(String title);
    void minusStoreCount(String title);
    void deleteUserInfo(UserDto userDto);

    //카운트 개수 가져오기
    StoreCountDto getStoreCount();

    //테스트
    void updateUserPwd(UserDto userDto);
    ArrayList<UserDto> getAllUser();
    UserDto searchUser(int userNo);
    void changeComNo(UserDto userDto);
}

package org.BG.Mapper;

import org.BG.DTO.AdminDto;
import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;

public interface LoginMapper {
    Integer appLogin(UserDto userDto);
    Integer appSendCode(RegisterDto registerDto);
    Integer appConfirmCodeOfRegister(RegisterDto registerDto);
    void appCleanRegister(String date);
    Integer appRegister(UserDto userDto);
    void appRegisterOfComImg(UserDto userDto);
    void appRegisterOfStore(UserDto userDto);
    String appSearchEmail(UserDto userDto);
    Integer appIsExistUserEmail(RegisterDto registerDto);
    void appChangePwd(UserDto userDto);

    Integer isUserVisitor(String date);
    void insertUserVisitor(String date);
    void updateUserVisitor(Integer visitor_no);

    AdminDto adminLogin();
}

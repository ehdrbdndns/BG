package org.BG.Service.login;

import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;

import java.io.IOException;

public interface LoginService {
    String appLogin(UserDto userDto);
    String appSendCodeOfRegister(RegisterDto registerDto);
    String appConfirmCodeOfRegister(RegisterDto registerDto);
    String appConfirmBusinessNumberOfRegister(UserDto userDto);
    String appRegister(UserDto userDto) throws IOException;
    String appSearchEmail(UserDto userDto);
    String appSendCodeOfSearch(RegisterDto registerDto);
    String appChangePwd(UserDto userDto);
    boolean adminLogin(String id, String pwd);
    String appCheckUserState(UserDto userDto);
    int isExistComNo(UserDto userDto);
}

package org.BG.Controller;

import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;
import org.BG.Service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    //로그인
    @ResponseBody
    @RequestMapping(value = "/appLogin.app")
    public String appLogin(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appLogin.app 호출");
            //User_No or err 반환
            return loginService.appLogin(userDto);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //이메일 인증 번호 전송(회원가입)
    @ResponseBody
    @RequestMapping(value = "/appSendCodeOfRegister.app")
    public String appSendCodeOfRegister(@ModelAttribute RegisterDto registerDto){
        try{
            System.out.println("/appSendCodeOfRegister.app 호출");
            //User_No or err 반환
            return loginService.appSendCodeOfRegister(registerDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //이메일 인증 번호 확인
    @ResponseBody
    @RequestMapping(value = "/appConfirmCode.app")
    public String appConfirmCodeOfRegister(@ModelAttribute RegisterDto registerDto){
        try{
            System.out.println("/appConfirmCode.app 호출");
            //true or false or err 반환
            return loginService.appConfirmCodeOfRegister(registerDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //사업자 등록번호 인증
    @ResponseBody
    @RequestMapping(value = "/appConfirmBusinessNumberOfRegister.app")
    public String appConfirmBusinessNumberOfRegister(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appConfirmBusinessNumberOfRegister.app 호출");
            String result = loginService.appConfirmBusinessNumberOfRegister(userDto);
            if(result.equals("사업을 하지 않고 있습니다.")){
                return "false";
            } else {
                return "true";
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //회원가입
    @ResponseBody
    @RequestMapping(value = "/appRegister.app")
    public String appRegister(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appRegister.app 호출");
            //true or err 반환
            return loginService.appRegister(userDto);
        } catch (IOException i){
            i.printStackTrace();
            return "[\"geocoder_Err\"]";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //아이디 찾기
    @ResponseBody
    @RequestMapping(value = "/appSearchEmail.app")
    public String appSearchEmail(@ModelAttribute UserDto userDto){
        try{
            return loginService.appSearchEmail(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //이메일 인증번호 전송(비밀번호 찾기)
    @ResponseBody
    @RequestMapping(value = "/appSendCodeOfSearch.app")
    public String appSendCodeOfSearch(@ModelAttribute RegisterDto registerDto){
        try{
            return loginService.appSendCodeOfSearch(registerDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //비밀번호 변경
    @ResponseBody
    @RequestMapping(value = "appChangePwd.app")
    public String appChangePwd(@ModelAttribute UserDto userDto){
        try{
            return loginService.appChangePwd(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

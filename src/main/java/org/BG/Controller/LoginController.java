package org.BG.Controller;

import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;
import org.BG.Service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    //회원 벤 상태 체크(0: 벤, 1: 노벤)
    @ResponseBody
    @RequestMapping(value = "/appCheckUserState.app")
    public String appCheckUserState(@ModelAttribute UserDto userDto){
        try{
            return loginService.appCheckUserState(userDto);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //로그인
    @ResponseBody
    @RequestMapping(value = "/appLogin.app")
    public String appLogin(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appLogin.app 호출");
            //User_No or err 반환
            String User_No = loginService.appLogin(userDto);
            System.out.println("/appLogin.app 리턴 값: " + User_No);
            return User_No;
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
            String registerNo = loginService.appSendCodeOfRegister(registerDto);
            System.out.println("registerNo: " + registerNo);
            return registerNo;
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
            //사업자 등록번호 유효성
            if(result.equals("사업을 하지 않고 있습니다.")){
                return "false";
            } else {
                //사업자 등록번호 중첩 여부 체크
                if(loginService.isExistComNo(userDto) == 1){
                    return "true";
                } else{
                    return "false";
                }
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

    @GetMapping("/login.do")
    public String loginPage() {
        return "login/login";
    }


    @GetMapping(value = "/adminLogout.do")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.do";
    }

    @RequestMapping(value = "/adminLogin.do", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpSession session) throws Exception {
        boolean isSuccess = loginService.adminLogin(id, pwd);
        if (isSuccess) {
            session.setAttribute("isLogin", true);
            return "redirect:/";
        }
        return "redirect:/";
    }
}

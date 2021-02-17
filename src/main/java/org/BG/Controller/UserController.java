package org.BG.Controller;

import org.BG.DTO.UserDto;
import org.BG.Service.user.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //회원 탈퇴
    @ResponseBody
    @RequestMapping(value = "/appDeleteUserInfo.app")
    public String appDeleteUserInfo(@ModelAttribute UserDto userDto){
        try{
            System.out.println("appDeleteUserInfo run");
            return userService.appDeleteUserInfo(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return "err";
        }
    }

    //회원 탈퇴
    @ResponseBody
    @RequestMapping(value = "/appTestDeleteUserInfo.app")
    public String appTestDeleteUserInfo(@ModelAttribute UserDto userDto){
        try{
            System.out.println("appTestDeleteUserInfo run");
            return userService.testDeleteUserInfo(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return "err";
        }
    }

    //내 정보 페이지(유저 정보 가져오기)
    @ResponseBody
    @RequestMapping(value = "/appRetrieveUserInfo.app")
    public JSONObject appRetrieveUserInfo(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appRetrieveUserInfo.app 호출");
            System.out.println("호출 User_No: " + userDto.getUser_No());
            return userService.appRetrieveUserInfo(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //내 정보 수정(저장)
    @ResponseBody
    @RequestMapping(value = "/appModifyUserInfo.app")
    public String appModifyUserInfo(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appModifyUserInfo.app 호출");
            System.out.println("user_no: " + userDto.getUser_No());
            if(userDto.getUser_No() == null){
                //변경사항 없음
                return "true";
            } else{
                //true or err 반환
                return userService.appModifyUserInfo(userDto);
            }
        } catch (IOException i){
            i.printStackTrace();
            return "geocoder_Err";
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    //환경설정 푸쉬 알림 서비스
    @ResponseBody
    @RequestMapping(value = "/appModifyUserAlarm.app")
    public String appModifyUserAlarm(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appModifyUserAlarm.app 호출");
            System.out.println("user_no: " + userDto.getUser_No());
            return userService.appModifyUserAlarm(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //환경설정 유저 정보 가져오기
    @ResponseBody
    @RequestMapping(value = "/appRetrieveUserAlarm.app")
    public JSONObject appRetrieveUserAlarm(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appRetrieveUserAlarm.app 호출");
            return userService.appRetrieveUserAlarm(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package org.BG.Controller;

import org.BG.Service.user.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VersionCheckController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/appCheckVersion.app")
    public String appCheckVersion(@RequestParam("version") String userVersion){
        try{
            /* 현재 앱 버전 */
            String version = userService.appCheckVersion();
            System.out.println("app version: " + version);
            System.out.println("user version: " + userVersion);

            if(version.equals("0.0.1234")){
                return "false";
            }

//            if(version.equals(userVersion) || userVersion.equals("0.0.1")){
//                System.out.println("버전 성공");
//                return "true";
//            } else{
//                System.out.println("버전 실패");
//                return "false";
//            }

            System.out.println("not user versionCheck");
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("버전 에러");
            return null;
        }
    }

    @RequestMapping(value = "/updateVersion.app")
    public String updateVersion(@RequestParam("version") String version){
        try{
            userService.updateVersion(version);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/homePage.do";
    }
}

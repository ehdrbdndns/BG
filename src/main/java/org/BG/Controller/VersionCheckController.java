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
            System.out.println("userVersion: " + userVersion);
            /* 현재 앱 버전 */
            String version = userService.appCheckVersion();
            if(version.equals(userVersion)){
                return "true";
            } else{
                return "false";
            }
        } catch (Exception e){
            e.printStackTrace();
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

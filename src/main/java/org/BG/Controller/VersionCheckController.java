package org.BG.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VersionCheckController {
    @ResponseBody
    @RequestMapping(value = "/appCheckVersion.app")
    public String appCheckVersion(@RequestParam("version") String userVersion){
        try{
            /* 현재 앱 버전 */
            String version = "0.0.1";
            if(version.equals(userVersion)){
                return "true";
            } else{
                System.out.println("사용자의 앱 버전: " + userVersion);
                return "false";
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

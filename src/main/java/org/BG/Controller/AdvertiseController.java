package org.BG.Controller;

import org.BG.DTO.AdvertiseDto;
import org.BG.Service.advertise.AdvertiseService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdvertiseController {
    @Autowired
    AdvertiseService advertiseService;

    @GetMapping("/advertisePage.do")
    public String advertisePage() {
        return "advertise/advertisePage";
    }

    //모든 광고 가져오기!
    @ResponseBody
    @RequestMapping(value = "/appGetAdvertise.app")
    public JSONObject appGetAdvertise(){
        try{
            return advertiseService.appGetAdvertise();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //광고 클릭 추가
    @ResponseBody
    @RequestMapping(value = "/appClickAdvertise.app")
    public boolean appClickAdvertise(@ModelAttribute AdvertiseDto advertiseDto){
        try{
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

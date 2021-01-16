package org.BG.Controller;

import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.BG.Service.store.StoreService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StoreController {
    @Autowired
    StoreService storeService;

    //나의 가게 관리(기존 정보 가져오기)
    @ResponseBody
    @RequestMapping(value = "/appRetrieveUserStore.app")
    public JSONObject appRetrieveUserStore(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appRetrieveUserStore.app 호출");
            System.out.println("userno: " + userDto.getUser_No());
            //jsonArray 반환
            return storeService.appRetrieveUserStore(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //나의 가게 관리(저장)
    @ResponseBody
    @RequestMapping(value = "/appSaveUserStore.app")
    public String appSaveUserStore(@ModelAttribute StoreDto storeDto){
        try{
            System.out.println("/appSaveUserStore.app 호출");
            //true or err 반환
            return storeService.appSaveUserStore(storeDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

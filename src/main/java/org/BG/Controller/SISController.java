package org.BG.Controller;

import org.BG.DTO.ShopinDto;
import org.BG.DTO.UserDto;
import org.BG.Service.sis.SISService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SISController {
    @Autowired
    SISService sisService;

    //샵인 샵 정보 리스트 요청
    @ResponseBody
    @RequestMapping(value = "/appRetrieveUserSISList.app")
    public JSONArray appRetrieveUserSISList(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appRetrieveUserSISList.app");
            return sisService.appRetrieveUserSISList(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //샵인 샵 추가 및 수정
    @ResponseBody
    @RequestMapping(value = "/appSaveUserSIS.app")
    public String appSaveUserSIS(@ModelAttribute ShopinDto shopinDto){
        try{
            System.out.println("/appSaveUserSIS.app 호출");
            //true or err 반환
            return sisService.appSaveUserSIS(shopinDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //샵인 샵 상세 페이지
    @ResponseBody
    @RequestMapping(value = "/appRetrieveUserSIS.app")
    public JSONObject appRetrieveUserSIS(@ModelAttribute ShopinDto shopinDto){
        try{
            System.out.println("/appRetrieveUserSiS.app 호출");
            return sisService.appRetrieveUserSIS(shopinDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //샵인 샵 삭제
    @ResponseBody
    @RequestMapping(value = "/appDeleteUserSIS.app")
    public String appDeleteUserSIS(@ModelAttribute ShopinDto shopinDto){
        try{
            System.out.println("/appDeleteUserSIS.app run");
            return sisService.appDeleteUserSIS(shopinDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

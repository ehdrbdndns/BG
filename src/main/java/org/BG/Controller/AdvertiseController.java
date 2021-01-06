package org.BG.Controller;

import org.BG.DTO.AdvertiseDto;
import org.BG.Service.advertise.AdvertiseService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class AdvertiseController {
    @Autowired
    AdvertiseService advertiseService;
    @Resource(name = "aws.filePath")
    String FILEPATH;

    @GetMapping("/advertisePage.do")
    public String advertisePage(Model model) {
        JSONObject advertiseInfo = new JSONObject();
        advertiseInfo = advertiseService.getAdvertise();

        //채팅 목록
        model.addAttribute("chat", advertiseInfo.get("chat"));

        //채팅 방
        model.addAttribute("chatRoom", advertiseInfo.get("chatRoom"));

        //메인 배너
        model.addAttribute("mainBanner", advertiseInfo.get("mainBanner"));

        //메인 탑
        model.addAttribute("mainTop", advertiseInfo.get("mainTop"));

        //메인 바텀
        model.addAttribute("mainBottom", advertiseInfo.get("mainBottom"));

        //바꿔먹어 광고
        model.addAttribute("changeEat", advertiseInfo.get("changeEat"));

        //시켜먹어 광고
        model.addAttribute("orderEat", advertiseInfo.get("orderEat"));

        //샵인 샵 광고
        model.addAttribute("shop", advertiseInfo.get("shop"));

        //상세 페이지 광고
        model.addAttribute("detail", advertiseInfo.get("detail"));

        //리뷰 광고
        model.addAttribute("review", advertiseInfo.get("review"));

        //커뮤니티 광고
        model.addAttribute("community", advertiseInfo.get("community"));

        model.addAttribute("FilePath", FILEPATH);
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
    public String appClickAdvertise(@ModelAttribute AdvertiseDto advertiseDto){
        try{
            if(advertiseService.appClickAdvertise(advertiseDto)){
                return "true";
            } else{
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //관리자에서 광고 추가
    @RequestMapping(value = "/uploadAdvertise.do", method = RequestMethod.POST)
    public String uploadAdvertise(@ModelAttribute AdvertiseDto advertiseDto){
        try{
            advertiseService.uploadAdvertise(advertiseDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return "redirect:/advertisePage.do";
    }

    //관리자에서 광고 삭제
    @GetMapping(value = "/deleteAdvertise.do")
    public String deleteAdvertise(@ModelAttribute AdvertiseDto advertiseDto){
        try{
            advertiseService.deleteAdvertise(advertiseDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return "redirect:/advertisePage.do";
    }

    //관리자에서 광고(리뷰나 커뮤니티) 삭제
    @GetMapping(value = "/deleteAdvertiseFromNo.do")
    public String deleteAdvertiseFromNo(@ModelAttribute AdvertiseDto advertiseDto){
        try{
            advertiseService.deleteAdvertiseFromNo(advertiseDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return "redirect:/advertisePage.do";
    }
}

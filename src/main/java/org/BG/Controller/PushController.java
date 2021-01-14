package org.BG.Controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.BG.DTO.PushDto;
import org.BG.Service.push.PushService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class PushController {
    @Autowired
    PushService pushService;

    @GetMapping(value = "pushPage.do")
    public String pushPage(Model model){
        ArrayList<PushDto> pushInfo = pushService.getPushInfo();
        model.addAttribute("pushInfo", pushInfo);
        return "push/pushPage";
    }

    @GetMapping(value = "pushDetailPage.do")
    public String pushDetailPage(@ModelAttribute PushDto pushDto, Model model){
        PushDto pushInfo = pushService.retrievePushInfo(pushDto);
        model.addAttribute("pushInfo", pushInfo);
        return "push/pushDetailPage";
    }

    @GetMapping(value = "pushMakePage.do")
    public String pushMakePage(){
        return "push/pushMakePage";
    }

    @GetMapping(value = "/deletePushInfo.do")
    public String deletePushInfo(@ModelAttribute PushDto pushDto){
        try{
            pushService.deletePushInfo(pushDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/pushPage.do";
    }

    @ResponseBody
    @RequestMapping(value = "/registerPushInfo.ajax", method = RequestMethod.POST)
    public Object registerPushInfo(@ModelAttribute PushDto pushDto){
        JSONObject result = new JSONObject();
        try{
            result.put("result", true);
            pushService.registerPushInfo(pushDto);
        }catch (Exception e){
            result.put("result", false);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPushInfo.ajax", method = RequestMethod.POST)
    public Object modifyPushInfo(@ModelAttribute PushDto pushDto){
        JSONObject result = new JSONObject();
        try{
            pushService.modifyPushInfo(pushDto);
            result.put("result", true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/sendPushContentToUser.ajax", method = RequestMethod.POST)
    public Object sendPushContentToUser(@ModelAttribute PushDto pushDto, HttpServletRequest request){
        JSONObject result = new JSONObject();
        try{
            pushService.sendPushContentToUser(request, pushDto);
            result.put("result", true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }
}

package org.BG.Controller;

import org.BG.DTO.NoticeDto;
import org.BG.Service.notice.NoticeService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping(value = "noticePage.do")
    public String noticePage(Model model){
        ArrayList<NoticeDto> noticeDtos = noticeService.getAnnounceList();
        model.addAttribute("noticeInfoList", noticeDtos);
        return "notice/noticePage";
    }

    @GetMapping(value = "noticeDetailPage.do")
    public String noticeDetailPage(Model model, @ModelAttribute NoticeDto noticeDto){
        NoticeDto noticeInfo = noticeService.getAnnounceInfo(noticeDto);
        model.addAttribute("noticeInfo", noticeInfo);
        return "notice/noticeDetailPage";
    }

    @GetMapping(value = "noticeMakePage.do")
    public String noticeMakePage(){
        return "notice/noticeMakePage";
    }

    @GetMapping(value = "deleteNotice.do")
    public String deleteNotice(@ModelAttribute NoticeDto noticeDto){
        try{
            noticeService.deleteNotice(noticeDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/noticePage.do";
    }

    //앱에서 공지사항 호출
    @ResponseBody
    @RequestMapping(value = "/appGetAnnounce.app")
    public String appGetAnnounce(){
        try{
            System.out.println("/appGetAnnounce.app 호출");
            return noticeService.appGetAnnounce();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //공지사항 추가
    @ResponseBody
    @RequestMapping(value = "/saveAnnounce.ajax")
    public Object saveAnnounce(@ModelAttribute NoticeDto noticeDto){
        JSONObject result = new JSONObject();
        try{
            result.put("result", noticeService.saveAnnounce(noticeDto));
        } catch (Exception e){
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }

    //공지사항 수정
    @ResponseBody
    @RequestMapping(value = "/modifyAnnounce.ajax")
    public Object modifyAnnounce(@ModelAttribute NoticeDto noticeDto){
        JSONObject result = new JSONObject();
        try{
            result.put("result", noticeService.modifyAnnounce(noticeDto));
        } catch (Exception e){
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }
}

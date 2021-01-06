package org.BG.Controller;

import org.BG.DTO.FaqDto;
import org.BG.Service.faq.FaqService;
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
public class FaqController {
    @Autowired
    FaqService faqService;

    @GetMapping(value = "/faqPage.do")
    public String faqPage(Model model) {
        ArrayList<FaqDto> faqDtos = faqService.getFaqList();
        model.addAttribute("faqInfoList", faqDtos);
        return "faq/faqPage";
    }

    @GetMapping(value = "/faqDetailPage.do")
    public String faqDetailPage(Model model, @ModelAttribute FaqDto faqDto) {
        FaqDto faqInfo = faqService.getFaqInfo(faqDto);
        model.addAttribute("faqInfo", faqInfo);
        return "faq/faqDetailPage";
    }

    @GetMapping(value = "/faqMakePage.do")
    public String faqMakePage() {
        return "faq/faqMakePage";
    }

    //앱에서 FAQ 호출
    @ResponseBody
    @RequestMapping(value = "/appGetFaq.app")
    public String appGetFaq(@ModelAttribute FaqDto faqDto) {
        try {
            return faqService.appGetFaq(faqDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //FAQ수정
    @ResponseBody
    @RequestMapping(value = "/modifyFaq.ajax")
    public Object modifyFaq(@ModelAttribute FaqDto faqDto) {
        JSONObject result = new JSONObject();
        try {
            result.put("result", faqService.modifyFaq(faqDto));
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }

    //FAQ삭제
    @GetMapping(value = "/deleteFaq.do")
    public String deleteFaq(@ModelAttribute FaqDto faqDto) {
        try {
            faqService.deleteFaq(faqDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/faqPage.do";
    }

    //FAQ작성
    @ResponseBody
    @RequestMapping(value = "/saveFaq.ajax")
    public Object saveFaq(@ModelAttribute FaqDto faqDto){
        JSONObject result = new JSONObject();
        try{
            result.put("result", faqService.saveFaq(faqDto));
        } catch (Exception e){
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }
}

package org.BG.Controller;

import org.BG.DTO.InquiryDto;
import org.BG.DTO.UserDto;
import org.BG.Service.inquiry.InquiryService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Controller
public class InquiryController {
    @Autowired
    InquiryService inquiryService;

    @GetMapping(value = "/inquiryPage.do")
    public String inquiryPage(Model model) {
        //문의 관리 리스트
        ArrayList<InquiryDto> inquiryDtos = inquiryService.getInquiryList();
        model.addAttribute("inquiryInfo", inquiryDtos);

        return "inquiry/inquiryPage";
    }

    @GetMapping(value = "/inquiryDetailPage.do")
    public String inquiryDetailPage(@ModelAttribute InquiryDto inquiryDto, Model model) {
        try{
            //문의 정보
            InquiryDto inquiryInfo = inquiryService.getInquiryInfo(inquiryDto);
            model.addAttribute("inquiryInfo", inquiryInfo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "inquiry/inquiryDetailPage";
    }

    //sendQuestion(문의하기)
    @ResponseBody
    @RequestMapping(value = "/appSendInquiry.app")
    public String appSendInquiry(@ModelAttribute InquiryDto inquiryDto) {
        try {
            System.out.println("/appSendInquiry.app 호출");
            //true or err 반환
            return inquiryService.appSendInquiry(inquiryDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //myQuestion(나의 문의)
    @ResponseBody
    @RequestMapping(value = "/appRetrieveInquiry.app")
    public String appRetrieveInquiry(@ModelAttribute UserDto userDto){
        try{
            System.out.println("/appRetrieveInquiry.app 호출");
            return inquiryService.appRetrieveInquiry(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //문의 내용 저장
    @ResponseBody
    @RequestMapping(value = "/saveInquiryInfo.ajax")
    public Object saveInquiryInfo(@ModelAttribute InquiryDto inquiryDto){
        JSONObject result = new JSONObject();
        try{
            result.put("result", inquiryService.answerInquiry(inquiryDto));
        } catch (Exception e){
            e.printStackTrace();
            result.put("result", false);
        }
        return result;
    }
}

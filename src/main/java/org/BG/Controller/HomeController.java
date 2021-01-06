package org.BG.Controller;

import org.BG.DTO.CommunityDto;
import org.BG.DTO.HomeDto;
import org.BG.DTO.LikeDto;
import org.BG.DTO.UserDto;
import org.BG.Service.community.CommunityService;
import org.BG.Service.home.HomeService;
import org.BG.Service.inquiry.InquiryService;
import org.BG.util.geocoder.Geocoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    HomeService homeService;
    @Autowired
    InquiryService inquiryService;
    @Autowired
    CommunityService communityService;
    @Autowired
    Geocoder geocoder;

    @GetMapping("/")
    public String main() {
        return "redirect:/homePage.do";
    }

    @GetMapping("/index.do")
    public String index() {
        return "index";
    }

    @GetMapping("/homePage.do")
    public String home(Model model, @RequestParam(required = false) String dayType) {
        // 일자 별 방문자 수
        JSONArray visitorCountOfDayType = homeService.getVisitorCount(dayType);
        model.addAttribute("visitorCountOfDayType", visitorCountOfDayType);

        //일자 별 회원가입 수
        JSONArray registerCountOfDayType = homeService.getRegisterCount(dayType);
        model.addAttribute("registerCountOfDayType", registerCountOfDayType);

        //문의 응답 및 미응답 개수
        JSONObject inquiryCountOfState = inquiryService.getInquiryCount();
        model.addAttribute("inquiryCountOfState", inquiryCountOfState);

        //신규 회원가입 DTO
        ArrayList<UserDto> userDtos = homeService.getNewUserInfoList();
        model.addAttribute("userInfoList", userDtos);

        //커뮤니티 DTO
        ArrayList<CommunityDto> communityDtos = communityService.getCommunityList();
        model.addAttribute("communityInfoList", communityDtos);

        return "homePage";
    }

    @GetMapping("/login.do")
    public String login() {
        return "login/login";
    }

    //메인페이지 시켜먹어, 바꿔먹어, 샵인 샵 리스트 가져오기
    //Store_Ways로 call, change, shopin으로 구분
    @ResponseBody
    @RequestMapping(value = "/appRetrieveShopList.app")
    public JSONArray appRetrieveShopList(@ModelAttribute HomeDto homeDto) {
        try {
            System.out.println("/appRetrieveShopList.app run");
            return homeService.appRetrieveShopList(homeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/appRetrieveShopDetail.app")
    public JSONObject appRetrieveShopDetail(@ModelAttribute HomeDto homeDto) {
        try {
            System.out.println("/appRetrieveShopDetail.app run");
            return homeService.appRetrieveShopDetail(homeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //좋아요 버튼 누름
    @ResponseBody
    @RequestMapping(value = "/appClickLikeBtn.app")
    public String appClickLikeBtn(@ModelAttribute LikeDto likeDto){
        try{
            System.out.println("/appClickLikeBtn.app run");
            System.out.println("Board_No: " + likeDto.getBoard_No());
            return homeService.appClickLikeBtn(likeDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //좋아요 버튼 눌렀는지 체크
    @ResponseBody
    @RequestMapping(value = "/appIsClickLike.app")
    public String appIsClickLike(@ModelAttribute LikeDto likeDto){
        try{
            System.out.println("/appIsClickLike.app run");
            return homeService.appIsClickLike(likeDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

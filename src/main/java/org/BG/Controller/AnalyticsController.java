package org.BG.Controller;

import org.BG.DTO.ProposalDto;
import org.BG.DTO.StoreDto;
import org.BG.Service.advertise.AdvertiseService;
import org.BG.Service.home.HomeService;
import org.BG.Service.inquiry.InquiryService;
import org.BG.Service.proposal.ProposalService;
import org.BG.Service.store.StoreService;
import org.BG.Service.user.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnalyticsController {
    @Autowired
    HomeService homeService;
    @Autowired
    ProposalService proposalService;
    @Autowired
    StoreService storeService;
    @Autowired
    AdvertiseService advertiseService;
    @Autowired
    UserService userService;

    @GetMapping("/analyticsPage.do")
    public String analyticsPage(Model model, @RequestParam(required = false) String dayType){
        // 일자 별 방문자 수
        JSONArray visitorCountOfDayType = homeService.getVisitorCount(dayType);
        model.addAttribute("visitorCountOfDayType", visitorCountOfDayType);

        //일자 별 회원가입 수
        JSONArray registerCountOfDayType = homeService.getRegisterCount(dayType);
        model.addAttribute("registerCountOfDayType", registerCountOfDayType);

        //바꿔먹어 시켜먹어 개수
        ProposalDto proposalDto = proposalService.countProposal();
        model.addAttribute("proposalInfo", proposalDto);

        //카테고리 별 입점 수
        JSONObject storeCategoryInfo = storeService.countStoreOfType();
        model.addAttribute("storeCategoryInfo", storeCategoryInfo);

        //광고 클릭 수
        JSONArray advertiseInfo = advertiseService.countAdvertiseV2();
//        JSONArray advertiseInfo = advertiseService.countAdvertise();
        model.addAttribute("advertiseInfo", advertiseInfo);

        //지역 별 입점 수
        JSONObject areaCount = userService.getUserAreaCount();
        model.addAttribute("areaCount" ,areaCount);

        return "analytics/analyticsPage";
    }
}

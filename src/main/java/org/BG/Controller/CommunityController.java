package org.BG.Controller;

import org.BG.DTO.CommunityDto;
import org.BG.DTO.UserDto;
import org.BG.Service.community.CommunityService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @Resource(name = "aws.filePath")
    String FilePath;

    @GetMapping(value = "/communityPage.do")
    public String communityPage(Model model){
        ArrayList<CommunityDto> communityDtos = communityService.getCommunityList();
        model.addAttribute("communityInfoList", communityDtos);
        return "community/communityPage";
    }

    @GetMapping(value = "/communityDetailPage.do")
    public String communityDetailPage(Model model, @ModelAttribute CommunityDto communityDto){
        CommunityDto communityInfo = communityService.getCommunityInfo(communityDto);
        model.addAttribute("communityInfo", communityInfo);
        model.addAttribute("filePath", FilePath);
        return "community/communityDetailPage";
    }

    //마이페이지 게시글 관리
    @ResponseBody
    @RequestMapping(value = "/appRetrieveCommunityListOfMy.app")
    public JSONArray appRetrieveCommunityListOfMy(UserDto userDto){
        try{
            System.out.println("/appRetrieveCommunityListOfMy.app 호출");
            return communityService.appRetrieveCommunityListOfMy(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //마이페이지 게시글 작성
    @ResponseBody
    @RequestMapping(value = "/appMakeCommunityOfMy.app")
    public String appMakeCommunityOfMy(@ModelAttribute CommunityDto communityDto){
        try{
            System.out.println("/appMakeCommunityOfMy.app 호출");
            return communityService.appMakeCommunityOfMy(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //마이페이지 게시글 수정(기본 데이터 가져오기)
    @ResponseBody
    @RequestMapping(value = "/appRetrieveCommunityOfMy.app")
    public JSONObject appRetrieveCommunityOfMy(@ModelAttribute CommunityDto communityDto){
        try{
            System.out.println("/appRetrieveCommunityOfMy.app 호출");
            return communityService.appRetrieveCommunityOfMy(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //마이페이지 게시글 수정(수정하기)
    @ResponseBody
    @RequestMapping(value = "/appModifyCommunityOfMy.app")
    public String appModifyCommunityOfMy(@ModelAttribute CommunityDto communityDto){
        try{
            System.out.println("/appModifyCommunityOfMy.app 호출");
            return communityService.appModifyCommunityOfMy(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //마이페이지 게시글 삭제
    @ResponseBody
    @RequestMapping(value = "/appDeleteCommunityOfMy.app")
    public String appDeleteCommunityOfMy(@ModelAttribute CommunityDto communityDto){
        try{
            System.out.println("/appDeleteCommunityOfMy.app 호출");
            return communityService.appDeleteCommunityOfMy(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //커뮤니티 리스트 뽑기
    @ResponseBody
    @RequestMapping(value = "/appRetrieveCommunityListOfMain.app")
    public JSONArray appRetrieveCommunityListOfMain(@ModelAttribute CommunityDto communityDto){
        try{
            System.out.println("/apRetrieveCommunityListOfMain.app 호출");
            return communityService.appRetrieveCommunityListOfMain(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //커뮤니티 상세 리스트
    @ResponseBody
    @RequestMapping(value = "/appRetrieveCommunityDetailOfMain.app")
    public JSONArray appRetrieveCommunityDetailOfMain(@ModelAttribute CommunityDto communityDto){
        try{
            System.out.println("/appRetrieveCommunityDetailOfMain.app 호출");
            return communityService.appRetrieveCommunityDetailOfMain(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //커뮤니티 삭제
    @GetMapping(value = "/deleteCommunity.do")
    public String deleteCommunity(@ModelAttribute CommunityDto communityDto){
        try{
            communityService.appDeleteCommunityOfMy(communityDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/communityPage.do";
    }

}

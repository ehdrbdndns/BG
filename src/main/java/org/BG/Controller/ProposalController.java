package org.BG.Controller;

import org.BG.DTO.HomeDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.BG.Service.home.HomeService;
import org.BG.Service.proposal.ProposalService;
import org.BG.Service.user.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ProposalController {
    @Autowired
    ProposalService proposalService;
    @Autowired
    UserService userService;
    @Autowired
    HomeService homeService;

    //제안 요청 리스트 요청
    @ResponseBody
    @RequestMapping(value = "/appRetrieveProposalList.app")
    public JSONArray appRetrieveProposalList(@ModelAttribute UserDto userDto){
        JSONArray result = new JSONArray();
        try{
            System.out.println("/appRetrieveProposalList.app 호출");
            ArrayList<ProposalDto> proposalDto = proposalService.appRetrieveProposalList(userDto);
            for(int i = 0; i<proposalDto.size(); i++){
                JSONObject item = new JSONObject();
                item.put("key", proposalDto.get(i).getProposal_No());
                item.put("profileUrl", proposalDto.get(i).getStore_Img());
                item.put("name", proposalDto.get(i).getUser_ComNm());
                item.put("address", proposalDto.get(i).getUser_Addr());
                item.put("way", proposalDto.get(i).getProposal_Ways());
                item.put("state", proposalDto.get(i).getProposal_State());
                item.put("regDate", proposalDto.get(i).getProposal_RegDate());
                result.add(item);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //바꿔먹어 제안 요청 상세 리스트
    @ResponseBody
    @RequestMapping(value = "/appRetrieveProposalDetailOfChangeEat.app")
    public JSONObject appRetrieveProposalDetailOfChangeEat(@ModelAttribute ProposalDto proposalDto){
        try{
            System.out.println("/appRetrieveProposalDetailOfChangeEat.app 호출");
            JSONObject result = proposalService.appRetrieveProposalDetailOfChangeEat(proposalDto);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //시켜먹어 제안 요청 상세 리스트
    @ResponseBody
    @RequestMapping(value = "/appRetrieveProposalDetailOfCallEat.app")
    public JSONObject appRetrieveProposalDetailOfCallEat(@ModelAttribute ProposalDto proposalDto){
        try{
            System.out.println("/appRetrieveProposalDetailOfCallEat.app 호출");
            return proposalService.appRetrieveProposalDetailOfCallEat(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //바꿔먹어 시켜먹어 제안 수락 및 거절
    @ResponseBody
    @RequestMapping(value = "/appChangeStateOfProposal.app")
    public String appChangeStateOfProposal(@ModelAttribute ProposalDto proposalDto){
        try{
            System.out.println("/appChangeStateOfProposal.app 호출");
            return proposalService.appChangeStateOfProposal(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // 제안서 요청서의 기본 데이터 요청
    @ResponseBody
    @RequestMapping(value = "/appGetProposalItem.app")
    public JSONObject appGetProposalItem(@ModelAttribute ProposalDto proposalDto){
        try{
            System.out.println("/appGetProposalItem.app 호출");
            return proposalService.appRetrieveProductFromUserNo(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //제안서 등록
    @ResponseBody
    @RequestMapping(value = "/appRegisterProposal.app")
    public String appRegisterProposal(@ModelAttribute ProposalDto proposalDto){
        try{
             System.out.println("/appRegisterProposal.app 호출");
             return proposalService.appRegisterProposal(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //채팅
    @ResponseBody
    @RequestMapping(value = "/appCheckChatRoom.app")
    public JSONObject appCheckChatRoom(@RequestParam("My_No") Integer My_No, @RequestParam("Your_No") Integer Your_No){
        JSONObject result = new JSONObject();
        try{
            System.out.println("/appCheckChatRoom.app 호출");
            result.put("state", proposalService.appCheckChatRoom(My_No, Your_No));

            UserDto myDto = new UserDto();
            myDto.setUser_No(My_No);
            JSONObject myInfo = userService.appRetrieveUserInfo(myDto);
            result.put("myInfo", myInfo);

            UserDto yourDto = new UserDto();
            yourDto.setUser_No(Your_No);
            JSONObject yourInfo = userService.appRetrieveUserInfo(yourDto);
            result.put("yourInfo", yourInfo);

            return result;
        } catch (Exception e){
            e.printStackTrace();
            result.put("state", false);
            return result;
        }
    }

    //채팅 알림 보내기
    @ResponseBody
    @RequestMapping(value = "/appSendChatAlarm.app")
    public String appSendChatAlarm(@RequestParam("Recipient_No") Integer Recipient_No, @RequestParam("Title") String title,  @RequestParam("Content") String Content, HttpServletRequest request){
        try{
            System.out.println("/appSendChatAlarm.app run");
            return proposalService.appSendChatAlarm(Recipient_No, title, Content, request);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

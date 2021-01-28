package org.BG.Service.proposal;

import org.BG.DTO.ProductDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface ProposalService {
    ArrayList<ProposalDto> appRetrieveProposalList(UserDto userDto);
    JSONObject appRetrieveProposalDetailOfChangeEat(ProposalDto proposalDto);
    JSONObject appRetrieveProposalDetailOfCallEat(ProposalDto proposalDto);
    String appChangeStateOfProposal(ProposalDto proposalDto);
    ProposalDto countProposal();
    JSONObject appRetrieveProductFromUserNo(ProposalDto proposalDto);
    String appRegisterProposal(ProposalDto proposalDto);
    boolean appCheckChatRoom(Integer My_No, Integer Your_No);
    String appSendChatAlarm(Integer Recipient_No, String title, String Content, HttpServletRequest request);
}

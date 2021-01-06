package org.BG.Service.proposal;

import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

public interface ProposalService {
    ArrayList<ProposalDto> appRetrieveProposalList(UserDto userDto);
    JSONObject appRetrieveProposalDetailOfChangeEat(ProposalDto proposalDto);
    JSONObject appRetrieveProposalDetailOfCallEat(ProposalDto proposalDto);
    String appChangeStateOfProposal(ProposalDto proposalDto);

    ProposalDto countProposal();
}

package org.BG.Mapper;

import org.BG.DTO.ProductDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

public interface ProposalMapper {
    ArrayList<ProposalDto> appRetrieveProposalList(UserDto userDto);

    //appRetrieveProposalDetailOfChangeEat
    ProposalDto appRetrieveProposalDetailOfChangeEatVerProposal(ProposalDto proposalDto);
    ProductDto appRetrieveProposalDetailOfChangeEatVerMyProduct(ProposalDto proposalDto);
    ProductDto appRetrieveProposalDetailOfChangeEatVerYourProduct(ProposalDto proposalDto);
    UserDto appRetrieveProposalDetailOfChangeEatVerUser(ProposalDto proposalDto);
    void appChangeStateOfProposal(ProposalDto proposalDto);
    int countProposalOfChange();
    int countProposalOfCall();
}

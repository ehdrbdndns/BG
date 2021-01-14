package org.BG.Mapper;

import org.BG.DAO.ProductDao;
import org.BG.DTO.ProductDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

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
    void appRegisterProposal(ProposalDto proposalDto);
    boolean appCheckChatRoom(@Param("My_No") Integer My_No, @Param("Your_No") Integer Your_No);
    void appInsertChatRoom(@Param("My_No") Integer My_No, @Param("Your_No") Integer Your_No);
}

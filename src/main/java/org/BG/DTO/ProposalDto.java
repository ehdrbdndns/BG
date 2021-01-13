package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposalDto {
    private Integer Proposal_No;
    private String Proposal_State;
    private String Proposal_Addr;
    private String Proposal_Ways;
    private Integer Proposal_Myproduct;
    private String Proposal_Category;
    private String Proposal_RegDate;
    private String Proposal_Id;
    private Integer User_No;
    private Integer Store_No;
    private Integer Product_No;
    private String Proposal_Credit;
    private String Proposal_Room;

    //제안 요청 리스트
    private String User_ComNm;
    private String User_Addr;
    private String Store_Img;

    //제안 요청 수
    private int changeCount;
    private int callCount;

    //송진자
    private int My_No;
    private int My_ProductNo;

    //수신자
    private int Your_No;
    private int Your_ProductNo;
}

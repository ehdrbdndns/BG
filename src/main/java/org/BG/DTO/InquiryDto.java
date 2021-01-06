package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquiryDto {
    private Integer Inquiry_No;
    private String Inquiry_Title;
    private String Inquiry_Answer;
    private String Inquiry_Category;
    private String Inquiry_RegDate;

    private Integer User_No;
    private String User_ComNm;
    private String User_Name;
    private String User_ComNo;
    private String User_Phone;
}

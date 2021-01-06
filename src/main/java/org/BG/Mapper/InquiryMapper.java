package org.BG.Mapper;

import org.BG.DTO.InquiryDto;
import org.BG.DTO.UserDto;

import java.util.ArrayList;

public interface InquiryMapper {
    void appSendInquiry(InquiryDto inquiryDto);
    ArrayList<InquiryDto> appRetrieveInquiry(UserDto userDto);
    int getInquiryCountOfReply();
    int getInquiryCountOfNotReply();
    ArrayList<InquiryDto> getInquiryList();
    InquiryDto getInquiryInfo(InquiryDto inquiryDto);
    void answerInquiry(InquiryDto inquiryDto);
}

package org.BG.Service.inquiry;

import org.BG.DTO.InquiryDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface InquiryService {
    String appSendInquiry(InquiryDto inquiryDto);
    String  appRetrieveInquiry(UserDto userDto);
    JSONObject getInquiryCount();
    ArrayList<InquiryDto> getInquiryList();
    InquiryDto getInquiryInfo(InquiryDto inquiryDto);
    boolean answerInquiry(InquiryDto inquiryDto);
}

package org.BG.Mapper;

import org.BG.DTO.FaqDto;

import java.util.ArrayList;

public interface FaqMapper {
    ArrayList<FaqDto> appGetFaq(FaqDto faqDto);
    ArrayList<FaqDto> getFaqList();
    FaqDto getFaqInfo(FaqDto faqDto);
    void modifyFaq(FaqDto faqDto);
    void deleteFaq(FaqDto faqDto);
    void saveFaq(FaqDto faqDto);
}

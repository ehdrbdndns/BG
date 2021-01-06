package org.BG.Service.faq;

import org.BG.DTO.FaqDto;

import java.util.ArrayList;

public interface FaqService {
    String appGetFaq(FaqDto faqDto);
    ArrayList<FaqDto> getFaqList();
    FaqDto getFaqInfo(FaqDto faqDto);
    boolean modifyFaq(FaqDto faqDto);
    boolean deleteFaq(FaqDto faqDto);
    boolean saveFaq(FaqDto faqDto);
}

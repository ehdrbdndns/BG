package org.BG.Service.faq;

import org.BG.DAO.FaqDao;
import org.BG.DTO.FaqDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


@Service
public class FaqServiceImp implements FaqService {
    @Autowired
    FaqDao faqDao;

    @Override
    public String appGetFaq(FaqDto faqDto) {
        try {
            JSONArray result = new JSONArray();
            ArrayList<FaqDto> faqDtos = faqDao.appGetFaq(faqDto);
            for(int i = 0; i<faqDtos.size(); i++){
                JSONObject faq = new JSONObject();
                faq.put("title", faqDtos.get(i).getAf_Title());
                faq.put("content", faqDtos.get(i).getAf_Contents());
                faq.put("regDate", faqDtos.get(i).getAf_RegDate());
                result.add(faq);
            }
            return result.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<FaqDto> getFaqList() {
        try{
            return faqDao.getFaqList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public FaqDto getFaqInfo(FaqDto faqDto) {
        try{
            return faqDao.getFaqInfo(faqDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean modifyFaq(FaqDto faqDto) {
        try{
            faqDto.setAf_RegDate(getToday());
            return faqDao.modifyFaq(faqDto);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFaq(FaqDto faqDto) {
        try{
            return faqDao.deleteFaq(faqDto);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveFaq(FaqDto faqDto) {
        try{
            faqDto.setAf_RegDate(getToday());
            return faqDao.saveFaq(faqDto);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}

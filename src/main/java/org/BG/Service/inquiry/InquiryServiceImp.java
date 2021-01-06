package org.BG.Service.inquiry;

import org.BG.DAO.InquiryDao;
import org.BG.DTO.InquiryDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class InquiryServiceImp implements InquiryService {
    @Autowired
    InquiryDao inquiryDao;

    @Override
    public String appSendInquiry(InquiryDto inquiryDto) {
        try{
            inquiryDto.setInquiry_RegDate(getToday());
            return inquiryDao.appSendInquiry(inquiryDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appRetrieveInquiry(UserDto userDto) {
        JSONArray result = new JSONArray();
        try{
            ArrayList<InquiryDto> inquiryDtos = inquiryDao.appRetrieveInquiry(userDto);
            for(int i = 0; i<inquiryDtos.size(); i++){
                JSONObject inquiry = new JSONObject();
                inquiry.put("title", inquiryDtos.get(i).getInquiry_Title());
                inquiry.put("anwser", inquiryDtos.get(i).getInquiry_Answer());
                inquiry.put("regDate", inquiryDtos.get(i).getInquiry_RegDate());
                result.add(inquiry);
            }
            return result.toJSONString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject getInquiryCount() {
        try{
            return inquiryDao.getInquiryCount();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<InquiryDto> getInquiryList() {
        try{
            return inquiryDao.getInquiryList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public InquiryDto getInquiryInfo(InquiryDto inquiryDto){
        try{
            return inquiryDao.getInquiryInfo(inquiryDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean answerInquiry(InquiryDto inquiryDto){
        try{
           return inquiryDao.answerInquiry(inquiryDto);
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

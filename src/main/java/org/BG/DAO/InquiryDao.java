package org.BG.DAO;

import org.BG.DTO.InquiryDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.InquiryMapper;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class InquiryDao {
    @Autowired
    SqlSession sqlSession;

    public String appSendInquiry(InquiryDto inquiryDto){
        try{
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            inquiryMapper.appSendInquiry(inquiryDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InquiryDto> appRetrieveInquiry(UserDto userDto){
        try{
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            return inquiryMapper.appRetrieveInquiry(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getInquiryCount(){
        JSONObject result = new JSONObject();
        try{
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            result.put("replyCount", inquiryMapper.getInquiryCountOfReply());
            result.put("notReplyCount", inquiryMapper.getInquiryCountOfNotReply());
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<InquiryDto> getInquiryList(){
        try{
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            return inquiryMapper.getInquiryList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public InquiryDto getInquiryInfo(InquiryDto inquiryDto){
        try{
            InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
            return inquiryMapper.getInquiryInfo(inquiryDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean answerInquiry(InquiryDto inquiryDto){
        try{
             InquiryMapper inquiryMapper = sqlSession.getMapper(InquiryMapper.class);
             inquiryMapper.answerInquiry(inquiryDto);
             return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

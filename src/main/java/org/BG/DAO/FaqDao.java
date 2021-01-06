package org.BG.DAO;

import org.BG.DTO.FaqDto;
import org.BG.Mapper.FaqMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FaqDao{
    @Autowired
    SqlSession sqlSession;

    public ArrayList<FaqDto> appGetFaq(FaqDto faqDto){
        try{
            FaqMapper faqMapper = sqlSession.getMapper(FaqMapper.class);
            return faqMapper.appGetFaq(faqDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<FaqDto> getFaqList(){
        try{
            FaqMapper faqMapper = sqlSession.getMapper(FaqMapper.class);
            return faqMapper.getFaqList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public FaqDto getFaqInfo(FaqDto faqDto){
        try{
            FaqMapper faqMapper = sqlSession.getMapper(FaqMapper.class);
            return faqMapper.getFaqInfo(faqDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean modifyFaq(FaqDto faqDto){
        try{
            FaqMapper faqMapper = sqlSession.getMapper(FaqMapper.class);
            faqMapper.modifyFaq(faqDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFaq(FaqDto faqDto){
        try{
            FaqMapper faqMapper = sqlSession.getMapper(FaqMapper.class);
            faqMapper.deleteFaq(faqDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveFaq(FaqDto faqDto){
        try{
            FaqMapper faqMapper = sqlSession.getMapper(FaqMapper.class);
            faqMapper.saveFaq(faqDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

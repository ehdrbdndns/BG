package org.BG.DAO;

import org.BG.DTO.ReplyDto;
import org.BG.Mapper.ReplyMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ReplyDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<ReplyDto> appRetrieveReply(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            return replyMapper.appRetrieveReply(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ReplyDto appRetrieveReplyOfReply(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            return replyMapper.appRetrieveReplyOfReply(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appUploadParentReply(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            Integer Reply_No = replyMapper.appUploadParentReply(replyDto);
            replyMapper.appUploadParentReplyOfGroupNum(Reply_No);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appUploadChildReply(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            replyMapper.appUploadChildReply(replyDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ReplyDto> appRetrieveReviews(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            return replyMapper.appRetrieveReviews(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appUploadParentReviews(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            Integer Reply_No = replyMapper.appUploadParentReviews(replyDto);
            replyMapper.appUploadParentReviewsOfGroupNum(Reply_No);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appUploadChildReviews(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
            replyMapper.appUploadChildReviews(replyDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ReplyDto appRetrieveReviewsOfReviews(ReplyDto replyDto){
        try{
            ReplyMapper replyMapper = sqlSession.getMapper(ReplyMapper.class);
           ReplyDto replyDtos = replyMapper.appRetrieveReviewsOfReviews(replyDto);

            return replyDtos;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

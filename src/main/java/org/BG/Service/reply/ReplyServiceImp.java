package org.BG.Service.reply;

import org.BG.DAO.ReplyDao;
import org.BG.DTO.ReplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class ReplyServiceImp implements ReplyService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public String appUploadParentReply(ReplyDto replyDto) {
        try{
            replyDto.setReply_RegDate(getToday());
            return replyDao.appUploadParentReply(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appUploadChildReply(ReplyDto replyDto) {
        try{
            replyDto.setReply_RegDate(getToday());
            return replyDao.appUploadChildReply(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appUploadParentReviews(ReplyDto replyDto) {
        try{
            replyDto.setReviews_RegDate(getToday());
            return replyDao.appUploadParentReviews(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appUploadChildReviews(ReplyDto replyDto) {
        try{
            replyDto.setReviews_RegDate(getToday());
            return replyDao.appUploadChildReviews(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(cal.getTime());
    }
}

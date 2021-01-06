package org.BG.Mapper;

import org.BG.DAO.ReplyDao;
import org.BG.DTO.ReplyDto;

import java.util.ArrayList;

public interface ReplyMapper {
    //커뮤니티
    ArrayList<ReplyDto> appRetrieveReply(ReplyDto replyDto);
    Integer appUploadParentReply(ReplyDto replyDto);
    void appUploadParentReplyOfGroupNum(Integer Reply_No);
    void appUploadChildReply(ReplyDto replyDto);
    ReplyDto appRetrieveReplyOfReply(ReplyDto replyDto);

    //스토어
    ArrayList<ReplyDto> appRetrieveReviews(ReplyDto replyDto);
    ReplyDto appRetrieveReviewsOfReviews(ReplyDto replyDto);
    Integer appUploadParentReviews(ReplyDto replyDto);
    void appUploadParentReviewsOfGroupNum(Integer Reviews_No);
    void appUploadChildReviews(ReplyDto replyDto);
}

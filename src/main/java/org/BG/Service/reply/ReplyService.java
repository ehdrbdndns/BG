package org.BG.Service.reply;

import org.BG.DAO.ReplyDao;
import org.BG.DTO.ReplyDto;

public interface ReplyService {
    String appUploadParentReply(ReplyDto replyDto);
    String appUploadChildReply(ReplyDto replyDto);

    String appUploadParentReviews(ReplyDto replyDto);
    String appUploadChildReviews(ReplyDto replyDto);
}

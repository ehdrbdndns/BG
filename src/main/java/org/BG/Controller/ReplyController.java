package org.BG.Controller;

import org.BG.DTO.ReplyDto;
import org.BG.Service.reply.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReplyController {
    @Autowired
    ReplyService replyService;

    //커뮤니티 부모 댓글 달기
    @ResponseBody
    @RequestMapping(value = "/appUploadParentReply.app")
    public String appUploadParentReply(@ModelAttribute ReplyDto replyDto){
        try{
            System.out.println("appUploadParentReply.app 호출");
            return replyService.appUploadParentReply(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //커뮤니티 자식 댓글 달기
    @ResponseBody
    @RequestMapping(value = "/appUploadChildReply.app")
    public String appUploadChildReply(@ModelAttribute ReplyDto replyDto){
        try{
            System.out.println("/appUploadChildReply.app 호출");
            return replyService.appUploadChildReply(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //상점 부모 댓글 달기
    @ResponseBody
    @RequestMapping(value = "/appUploadParentReviews.app")
    public String appUploadParentReviews(@ModelAttribute ReplyDto replyDto){
        try{
            System.out.println("appUploadParentReviews.app 호출");
            return replyService.appUploadParentReviews(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //상점 자식 댓글 달기
    @ResponseBody
    @RequestMapping(value = "/appUploadChildReviews.app")
    public String appUploadChildReviews(@ModelAttribute ReplyDto replyDto){
        try{
            System.out.println("/appUploadChildReviews.app 호출");
            System.out.println("Reviews_No: " + replyDto.getReviews_No());
            return replyService.appUploadChildReviews(replyDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

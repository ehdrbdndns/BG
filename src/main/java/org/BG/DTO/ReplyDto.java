package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {
    private Integer Reply_No;
    private String Reply_Comments;
    private String Reply_RegDate;
    private Integer Community_No;
    private Integer Reply_Group;
    private Integer Reply_Class;
    private Integer Reply_Order;

    private Integer User_No;
    private String User_Name;
    private String Store_Img;

    private Integer Reviews_No;
    private String Reviews_Comments;
    private String Reviews_RegDate;
    private Integer Store_No;
    private Integer Reviews_Group;
    private Integer Reviews_Class;
    private Integer Reviews_Order;

    //대댓글
    private String RR_UserName;
    private String RR_StoreImg;
    private String RR_Comments;
    private String RR_RegDate;
}

package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertiseDto {
    private Integer Ad_No;
    private String Ad_ChatList;
    private String Ad_ChatRoom;
    private String Ad_MainBanner;
    private String Ad_MainTop;
    private String Ad_MainBottom;
    private String Ad_Change;
    private String Ad_Request;
    private String Ad_Shopin;
    private String Ad_Details;
    private String Ad_Reviews;
    private String Ad_Community;
    private int Ad_ReviewsCon;
    private int Ad_CommunityCount;

    private String Ad_Url;
    private String Ad_Type;
}
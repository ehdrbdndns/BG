package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Getter
@Setter
public class UserDto {
    private Integer User_No;
    private String User_Email;
    private String User_PW;
    private String User_Name;
    private String User_Phone;
    private String User_ComNo;
    private String User_ComNm;
    private String User_Addr;
    private String User_Details;
    private String User_ComImg;
    private String User_RegDate;
    private Double User_Lat;
    private Double User_Lng;
    private String User_Alarm1;
    private String User_Alarm2;
    private String User_Alarm3;
    private String User_Fcm;
    private int User_State;

    //유저 알람 상태
    private String Category;
    private String State;

    private MultipartFile User_ComImg_File;

    //제안 요청 리스트에 사용될 Store_No
    private Integer Store_No;

    //마이페이지에서 사용 됨
    private String Store_Img;
    private MultipartFile Store_Img_File;
}

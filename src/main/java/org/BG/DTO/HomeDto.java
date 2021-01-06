package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class HomeDto {
    private String Location;
    private int Location_Range;

    //ShopIndex
    private int FirstIndex;
    private int LastIndex;

    //검색
    private String Search;

    //한식 중식 등등
    private String Ways;

    //바꿔머거 시켜먹어 샵인샵
    private String Category;

    //위도 경도
    private Double Lat;
    private Double Lng;

    //상품 음식 이름
    private ArrayList<String> Product_Name;

    //상점 or 샵인 샵 주소
    private String User_Addr;

    //상점
    private int Store_No;
    private String Store_Img;
    private String User_ComNm;
    private String Store_Category;
    private String Store_Desc;
    private String Store_MainMenu;

    //샵인 샵
    private int Shopin_No;
    private String Shopin_Name;
    private String Shopin_Img;
    private String Shopin_Category;
    private String Shopin_MainMenu;

    //거리 값
    private Float distance;

    //유저 정보
    private int User_No;
    private String User_RegDate;
}

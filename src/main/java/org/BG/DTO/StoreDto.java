package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class StoreDto {
    private Integer Store_No;
    private String Store_Ways;
    private String Store_Category;
    private String Store_MainMenu;
    private String Store_Desc;
    private String Store_Img;
    private Integer Store_Likes;

    private Integer User_No;
    private String User_Details;
    private Double User_Lat;
    private Double User_Lng;
    private String User_ComNm;

    private ArrayList<ProductDto> Product_List;
}

package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ShopinDto {
    private Integer Shopin_No;
    private String Shopin_Ways;
    private String Shopin_Category;
    private String Shopin_MainMenu;
    private String Shopin_Desc;
    private Integer Shopin_Likes;
    private String Shopin_Img;
    private MultipartFile Shopin_Img_File;
    private String Shopin_Name;
    private Integer Store_No;

    private Integer User_No;
}

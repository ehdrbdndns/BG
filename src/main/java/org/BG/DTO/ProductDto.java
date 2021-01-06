package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDto {
    private Integer Product_No;
    private String Product_Name;
    private String Product_Compo;
    private Integer Product_Price;
    private Integer Product_Sales;
    private String Product_Type;
    private String Product_Img;
    private Integer Shopin_No;
    private Integer Store_No;

    private MultipartFile Product_Img_File;

    private Integer User_No;
}

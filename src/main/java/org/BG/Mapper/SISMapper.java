package org.BG.Mapper;

import org.BG.DTO.ProductDto;
import org.BG.DTO.ShopinDto;

import java.util.ArrayList;

public interface SISMapper {
    ArrayList<ShopinDto> appRetrieveUserSISList(int Store_No);
    void appSaveUserSISOfAdd(ShopinDto shopinDto);
    ShopinDto appRetrieveUserSISOfImg(ShopinDto shopinDto);
    void appSaveUserSISOfModify(ShopinDto shopinDto);
    ShopinDto appRetrieveUserSISVerShopin(ShopinDto shopinDto);
    ArrayList<ProductDto> appRetrieveUserSISVerProduct(int Shopin_No);
    String appDeleteUserSIS(ShopinDto shopinDto);
}

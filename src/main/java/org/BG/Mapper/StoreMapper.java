package org.BG.Mapper;

import org.BG.DTO.ProductDto;
import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;

import java.util.ArrayList;

public interface StoreMapper {
    StoreDto appRetrieveUserStoreVerStoreOfStoreNo(StoreDto storeDto);
    StoreDto appRetrieveUserStoreVerStore(UserDto userDto);
    ArrayList<ProductDto> appRetrieveUserStoreVerProduct(int Store_No);
    Integer appRetrieveStoreNo(int User_No);
    void appSaveUserStoreVerStore(StoreDto storeDto);
    ArrayList<StoreDto> countStoreOfType();
}

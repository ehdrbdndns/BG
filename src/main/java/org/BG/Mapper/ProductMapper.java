package org.BG.Mapper;

import org.BG.DTO.ProductDto;

import java.util.ArrayList;

public interface ProductMapper {
    ProductDto appRetrieveStoreProduct(ProductDto productDto);
    void appMakeUserStoreProduct(ProductDto productDto);
    void appDeleteUserStoreProduct(ProductDto productDto);
    void appModifyUserStoreProduct(ProductDto productDto);
    void appMakeUserSISProduct(ProductDto productDto);
    void appDeleteUserSISProduct(ProductDto productDto);
    void appModifyUserSISProduct(ProductDto productDto);
    ArrayList<ProductDto> appRetrieveProductVerStore(Integer Store_No);
    ArrayList<String> appRetrieveProductNameVerShopin(Integer Shopin_No);
}

package org.BG.Service.product;

import org.BG.DTO.ProductDto;

public interface ProductService {
    String appMakeUserStoreProduct(ProductDto productDto);
    String appDeleteUserStoreProduct(ProductDto productDto);
    String appModifyUserStoreProduct(ProductDto productDto);
    String appMakeUserSISProduct(ProductDto productDto);
    String appDeleteUserSISProduct(ProductDto productDto);
    String appModifyUserSISProduct(ProductDto productDto);
}

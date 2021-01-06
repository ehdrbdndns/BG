package org.BG.Service.product;

import org.BG.DAO.ProductDao;
import org.BG.DAO.StoreDao;
import org.BG.DAO.UserDao;
import org.BG.DTO.ProductDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    StoreDao storeDao;
    @Autowired
    Aws_Cdn_Service aws_cdn_service;

    public String appMakeUserStoreProduct(ProductDto productDto) {
        try {
            Integer Store_No = storeDao.appRetrieveStoreNo(productDto.getUser_No());
            productDto.setStore_No(Store_No);
            String Product_Img = aws_cdn_service.FileUpload("user/" + productDto.getUser_No() + "/store/productImg/", productDto.getProduct_Img_File());
            productDto.setProduct_Img(Product_Img);
            return productDao.appMakeUserStoreProduct(productDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appDeleteUserStoreProduct(ProductDto productDto) {
        try {
            String deleteProductImg = productDao.appRetrieveStoreProduct(productDto).getProduct_Img();
            aws_cdn_service.FileDelete(deleteProductImg);
            return productDao.appDeleteUserStoreProduct(productDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appModifyUserStoreProduct(ProductDto productDto) {
        try {
            String basicProduct = productDao.appRetrieveStoreProduct(productDto).getProduct_Img();
            if (!productDto.getProduct_Img_File().isEmpty()) {
                String Product_Img = aws_cdn_service.FileUpload("user/" + productDto.getUser_No() + "/store/productImg/", productDto.getProduct_Img_File());
                productDto.setProduct_Img(Product_Img);
                aws_cdn_service.FileDelete(basicProduct);
            } else {
                productDto.setProduct_Img(basicProduct);
            }
            return productDao.appModifyUserStoreProduct(productDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appMakeUserSISProduct(ProductDto productDto) {
        try {
            String Product_Img = aws_cdn_service.FileUpload("user/" + productDto.getUser_No() + "/shopin/" + productDto.getShopin_No() + "/shopinImg/", productDto.getProduct_Img_File());
            productDto.setProduct_Img(Product_Img);
            return productDao.appMakeUserSISProduct(productDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appDeleteUserSISProduct(ProductDto productDto) {
        try{
            aws_cdn_service.FileDelete("user/" + productDto.getUser_No() + "/shopin/" + productDto.getShopin_No() + "/shopinImg");
            return productDao.appDeleteUserSISProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appModifyUserSISProduct(ProductDto productDto) {
        try{
            if(!productDto.getProduct_Img_File().isEmpty()){
                aws_cdn_service.FileDelete("user/" + productDto.getUser_No() + "/shopin/" + productDto.getShopin_No() + "/shopinImg");
                String Product_Img = aws_cdn_service.FileUpload("user/" + productDto.getUser_No() + "/shopin/" + productDto.getShopin_No() + "/shopinImg/", productDto.getProduct_Img_File());
                productDto.setProduct_Img(Product_Img);
            } else{
                String basicProductImg = productDao.appRetrieveStoreProduct(productDto).getProduct_Img();
                productDto.setProduct_Img(basicProductImg);
            }
            return productDao.appModifyUserSISProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
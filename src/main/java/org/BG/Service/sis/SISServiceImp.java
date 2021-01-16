package org.BG.Service.sis;

import org.BG.DAO.SISDao;
import org.BG.DAO.StoreDao;
import org.BG.DTO.ProductDto;
import org.BG.DTO.ShopinDto;
import org.BG.DTO.UserDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SISServiceImp implements SISService {
    @Autowired
    SISDao sisDao;
    @Autowired
    StoreDao storeDao;
    @Autowired
    Aws_Cdn_Service aws_cdn_service;

    @Override
    public JSONArray appRetrieveUserSISList(UserDto userDto) {
        JSONArray result = new JSONArray();
        try {
            Integer store_No = storeDao.appRetrieveStoreNo(userDto.getUser_No());
            if (store_No != null) {
                ArrayList<ShopinDto> shopinDtoArrayList = sisDao.appRetrieveUserSISList(store_No);
                for (int i = 0; i < shopinDtoArrayList.size(); i++) {
                    JSONObject jsonObjectShopin = new JSONObject();
                    jsonObjectShopin.put("key", shopinDtoArrayList.get(i).getShopin_No());
                    jsonObjectShopin.put("name", shopinDtoArrayList.get(i).getShopin_Name());
                    jsonObjectShopin.put("img", shopinDtoArrayList.get(i).getShopin_Img());
                    result.add(jsonObjectShopin);
                }
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String appSaveUserSIS(ShopinDto shopinDto) {
        try {
            if (shopinDto.getShopin_No() == 0) {
                //샵인 샵 정보 추가
                Integer Store_No = storeDao.appRetrieveStoreNo(shopinDto.getUser_No());
                if (Store_No != null) {
                    shopinDto.setStore_No(Store_No);
                    String shopin_Img = aws_cdn_service.FileUpload("user/" + shopinDto.getUser_No() + "/shopin/shopinImg/", shopinDto.getShopin_Img_File());
                    shopinDto.setShopin_Img(shopin_Img);
                    return sisDao.appSaveUserSISOfAdd(shopinDto);
                } else {
                    System.out.println("store_no의 값이 null이다.");
                    return null;
                }
            } else {
                //샵인 샵 정보 수정
                if (shopinDto.getShopin_Img_File() != null) {
                    String basicImgPath = sisDao.appRetrieveUserSISOfImg(shopinDto).getShopin_Img();
                    aws_cdn_service.FileDelete("user/" + shopinDto.getUser_No() + "/shopin/shopinImg/"+basicImgPath);
                    String shopin_Img = aws_cdn_service.FileUpload("user/" + shopinDto.getUser_No() + "/shopin/shopinImg/", shopinDto.getShopin_Img_File());
                    shopinDto.setShopin_Img(shopin_Img);
                } else {
                    String basicShopinImg = sisDao.appRetrieveUserSISVerShopin(shopinDto).getShopin_Img();
                    shopinDto.setShopin_Img(basicShopinImg);
                }
                return sisDao.appSaveUserSISOfModify(shopinDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject appRetrieveUserSIS(ShopinDto shopinDto) {
        try {
            JSONObject result = new JSONObject();
            JSONArray productList = new JSONArray();
            ShopinDto shopin = sisDao.appRetrieveUserSISVerShopin(shopinDto);
            result.put("category", shopin.getShopin_Category());
            result.put("mainMenu", shopin.getShopin_MainMenu());
            result.put("desc", shopin.getShopin_Desc());
            result.put("ways", shopin.getShopin_Ways());

            ArrayList<ProductDto> productDtos = sisDao.appRetrieveUserSISVerProduct(shopinDto.getShopin_No());
            for (int i = 0; i < productDtos.size(); i++) {
                JSONObject product = new JSONObject();
                product.put("key", productDtos.get(i).getProduct_No());
                product.put("name", productDtos.get(i).getProduct_Name());
                product.put("img", productDtos.get(i).getProduct_Img());
                product.put("price", productDtos.get(i).getProduct_Price());
                product.put("sales", productDtos.get(i).getProduct_Sales());
                product.put("compo", productDtos.get(i).getProduct_Compo());
                product.put("type", productDtos.get(i).getProduct_Type());
                productList.add(product);
            }
            result.put("productList", productList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appDeleteUserSIS(ShopinDto shopinDto) {
        try {
            return sisDao.appDeleteUserSIS(shopinDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

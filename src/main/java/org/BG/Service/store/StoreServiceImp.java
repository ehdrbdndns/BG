package org.BG.Service.store;

import org.BG.DAO.ProductDao;
import org.BG.DAO.StoreDao;
import org.BG.DTO.ProductDto;
import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreServiceImp implements StoreService {
    @Autowired
    StoreDao storeDao;
    @Autowired
    ProductDao productDao;

    @Override
    public JSONObject appRetrieveUserStore(UserDto userDto) {
        JSONObject result = new JSONObject();
        JSONArray productList = new JSONArray();
        try {
            //상점 정보에 대한 DTO
            StoreDto storeDto = storeDao.appRetrieveUserStoreVerStore(userDto);
            //상점에 등록된 상품 리스트에 대한 DTO
            ArrayList<ProductDto> productDtos = storeDao.appRetrieveUserStoreVerProduct(storeDto.getStore_No());

            //상점 정보 등록
            result.put("category", storeDto.getStore_Category());
            result.put("mainMenu", storeDto.getStore_MainMenu());
            result.put("desc", storeDto.getStore_Desc());
            result.put("ways", storeDto.getStore_Ways());

            //상점의 품목 등록
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
    public String appSaveUserStore(StoreDto storeDto) {
        String check = "";
        try {
            Integer store_No = storeDao.appRetrieveStoreNo(storeDto.getUser_No());
            if (store_No != null) {
                storeDto.setStore_No(store_No);
                return storeDao.appSaveUserStoreVerStore(storeDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StoreDto getStoreInfo(UserDto userDto) {
        StoreDto result = new StoreDto();
        try{
            // 기업 정보
            result = storeDao.appRetrieveUserStoreVerStore(userDto);
            // 기업의 상품 정보
            ArrayList<ProductDto> productDtos = productDao.appRetrieveProductVerStore(result.getStore_No());
            result.setProduct_List(productDtos);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}

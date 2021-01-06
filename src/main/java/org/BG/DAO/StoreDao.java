package org.BG.DAO;

import org.BG.DTO.ProductDto;
import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.StoreMapper;
import org.BG.Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StoreDao {
    @Autowired
    SqlSession sqlSession;

    public StoreDto appRetrieveUserStoreVerStore(UserDto userDto){
        StoreDto storeDto = new StoreDto();
        try{
            StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
            storeDto = storeMapper.appRetrieveUserStoreVerStore(userDto);
            return storeDto;
        } catch (Exception e){
            e.printStackTrace();
            return storeDto;
        }
    }

    public ArrayList<ProductDto> appRetrieveUserStoreVerProduct(int Store_No){
        ArrayList<ProductDto> productDtoArrayList = new ArrayList<>();
        try{
             StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
            productDtoArrayList = storeMapper.appRetrieveUserStoreVerProduct(Store_No);
            return productDtoArrayList;
        } catch (Exception e){
            e.printStackTrace();
            return productDtoArrayList;
        }
    }

    public Integer appRetrieveStoreNo(int user_No){
        try{
             StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
            return storeMapper.appRetrieveStoreNo(user_No);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appSaveUserStoreVerStore(StoreDto storeDto){
        try{
             StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
            storeMapper.appSaveUserStoreVerStore(storeDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public StoreDto appRetrieveUserStoreVerStoreOfStoreNo(StoreDto storeDto){
        try{
            StoreMapper storeMapper = sqlSession.getMapper(StoreMapper.class);
            return storeMapper.appRetrieveUserStoreVerStoreOfStoreNo(storeDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

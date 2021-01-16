package org.BG.DAO;

import org.BG.DTO.ProductDto;
import org.BG.DTO.ShopinDto;
import org.BG.Mapper.SISMapper;
import org.BG.Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SISDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<ShopinDto> appRetrieveUserSISList(int Store_No){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            return sisMapper.appRetrieveUserSISList(Store_No);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appSaveUserSISOfAdd(ShopinDto shopinDto){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            sisMapper.appSaveUserSISOfAdd(shopinDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appSaveUserSISOfModify(ShopinDto shopinDto){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            sisMapper.appSaveUserSISOfModify(shopinDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ShopinDto appRetrieveUserSISOfImg(ShopinDto shopinDto){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            return sisMapper.appRetrieveUserSISOfImg(shopinDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ShopinDto appRetrieveUserSISVerShopin(ShopinDto shopinDto){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            return sisMapper.appRetrieveUserSISVerShopin(shopinDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ProductDto> appRetrieveUserSISVerProduct(int Shopin_No){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            return sisMapper.appRetrieveUserSISVerProduct(Shopin_No);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appDeleteUserSIS(ShopinDto shopinDto){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            sisMapper.appDeleteUserSIS(shopinDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public  ArrayList<ShopinDto> appRetrieveSISNoFromStore_No(int Store_No){
        try{
            SISMapper sisMapper = sqlSession.getMapper(SISMapper.class);
            return sisMapper.appRetrieveSISNoFromStore_No(Store_No);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

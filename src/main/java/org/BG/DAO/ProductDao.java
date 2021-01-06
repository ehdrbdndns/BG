package org.BG.DAO;

import org.BG.DTO.HomeDto;
import org.BG.DTO.ProductDto;
import org.BG.Mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductDao {
    @Autowired
    SqlSession sqlSession;

    public ProductDto appRetrieveStoreProduct(ProductDto productDto){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.appRetrieveStoreProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appMakeUserStoreProduct(ProductDto productDto){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.appMakeUserStoreProduct(productDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appDeleteUserStoreProduct(ProductDto productDto){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.appDeleteUserStoreProduct(productDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appModifyUserStoreProduct(ProductDto productDto){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.appModifyUserStoreProduct(productDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appMakeUserSISProduct(ProductDto productDto){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.appMakeUserSISProduct(productDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appDeleteUserSISProduct(ProductDto productDto){
        try{
             ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
             productMapper.appDeleteUserSISProduct(productDto);
             return "true";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appModifyUserSISProduct(ProductDto productDto){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            productMapper.appModifyUserSISProduct(productDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ProductDto> appRetrieveProductVerStore(Integer Store_No){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.appRetrieveProductVerStore(Store_No);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> appRetrieveProductNameVerShopin(Integer Shopin_No){
        try{
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.appRetrieveProductNameVerShopin(Shopin_No);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

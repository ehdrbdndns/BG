package org.BG.Controller;

import org.BG.DTO.ProductDto;
import org.BG.Service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    //나의 가게 상품 추가
    @ResponseBody
    @RequestMapping(value = "/appMakeUserStoreProduct.app")
    public String appMakeUserStoreProduct(@ModelAttribute ProductDto productDto){
        try{
            System.out.println("/appMakeUserStoreProduct.app 호출");
            return productService.appMakeUserStoreProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //나의 가게 상품 삭제
    @ResponseBody
    @RequestMapping(value = "/appDeleteUserStoreProduct.app")
    public String appDeleteUserStoreProduct(@ModelAttribute ProductDto productDto){
        try{
            System.out.println("/appDeleteUserStoreProduct.app 호출");
            return productService.appDeleteUserStoreProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //나의 가게 상품 수정
    @ResponseBody
    @RequestMapping(value = "/appModifyUserStoreProduct.app")
    public String appModifyUserStoreProduct(@ModelAttribute ProductDto productDto){
        try{
            System.out.println("/appModifyUserStoreProduct.app 호출");
            return productService.appModifyUserStoreProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }

    //샵인 샵 가게 상품 추가
    @ResponseBody
    @RequestMapping(value = "/appMakeUserSISProduct.app")
    public String appMakeUserSISProduct(@ModelAttribute ProductDto productDto){
        try{
            System.out.println("/appMakeUserSISProduct.app 호출");
            return productService.appMakeUserSISProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //샵인 샵 상품 삭제
    @ResponseBody
    @RequestMapping(value = "/appDeleteUserSISProduct.app")
    public String appDeleteUserSISProduct(@ModelAttribute ProductDto productDto){
        try{
            System.out.println("/appDeleteUserSISProduct.app");
            return productService.appDeleteUserSISProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //샵인 샵 상품 수정
    @ResponseBody
    @RequestMapping(value = "/appModifyUserSISProduct.app")
    public String appModifyUserSISProduct(@ModelAttribute ProductDto productDto){
        try{
            System.out.println("/appModifyUserSISProduct.app 호출");
            return productService.appModifyUserSISProduct(productDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

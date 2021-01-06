package org.BG.Controller;

import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.BG.Service.store.StoreService;
import org.BG.Service.user.UserService;
import org.BG.Service.user.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class MemberController {
    @Autowired
    UserService userService;
    @Autowired
    StoreService storeService;

    @Resource(name = "aws.filePath")
    String FilePath;

    @GetMapping(value = "memberPage.do")
    public String memberPage(Model model){
        try{
            //유저 정보 리스트
            ArrayList<UserDto> userDtos = userService.getUserList();
            model.addAttribute("userInfoList", userDtos);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "member/memberPage";
    }

    @GetMapping(value = "/memberDetailPage.do")
    public String memberPageDetail(@ModelAttribute UserDto userDto, Model model){
        try{
            //유저 정보 가져오기
            UserDto userInfo = userService.getUserInfo(userDto);
            model.addAttribute("userInfo", userInfo);
            //유저에 대한 기업 정보 가져오기
            StoreDto storeInfo = storeService.getStoreInfo(userDto);
            model.addAttribute("storeInfo", storeInfo);

            model.addAttribute("filePath", FilePath);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "member/memberDetailPage";
    }
}

package org.BG.Service.home;

import org.BG.DTO.HomeDto;
import org.BG.DTO.LikeDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public interface HomeService {
    JSONArray appRetrieveShopList(HomeDto homeDto) throws IOException;
    JSONObject appRetrieveShopDetail(HomeDto homeDto);
    JSONArray getVisitorCount(String dayType);
    JSONArray getRegisterCount(String dayType);
    ArrayList<UserDto> getNewUserInfoList();
    String appClickLikeBtn(LikeDto likeDto);
    String appIsClickLike(LikeDto likeDto);
}

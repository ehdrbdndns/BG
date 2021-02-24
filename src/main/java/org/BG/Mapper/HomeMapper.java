package org.BG.Mapper;

import org.BG.DTO.HomeDto;
import org.BG.DTO.LikeDto;
import org.BG.DTO.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface HomeMapper {
    ArrayList<HomeDto> appRetrieveStoreInfoOfLatitude(HomeDto homeDto);
    ArrayList<HomeDto> appRetrieveSISInfoOfLatitude(HomeDto homeDto);
    HomeDto appRetrieveShopListVerStore(HomeDto homeDto);
    HomeDto appRetrieveShopListVerSIS(HomeDto homeDto);
    Integer getTodayVisitorCount(String date);
    Integer getAnywayVisitorCount(@Param("startDate") String startDate, @Param("endDate") String endDate);
    Integer getTodayRegisterCount(String date);
    Integer getAnywayRegisterCount(@Param("startDate") String startDate, @Param("endDate") String endDate);
    ArrayList<UserDto> getNewUserInfoList(String date);
    void appPlusLikeOfCommunity(LikeDto likeDto);
    void appPlusLikeOfStore(LikeDto likeDto);
    void appInsertLikeOfCommunity(LikeDto likeDto);
    void appInsertLikeOfStore(LikeDto likeDto);
    void appMinusLikeOfCommunity(LikeDto likeDto);
    void appMinusLikeOfStore(LikeDto likeDto);
    void appDeleteLikeOfCommunity(LikeDto likeDto);
    void appDeleteLikeOfStore(LikeDto likeDto);
    boolean appIsClickLikeOfCommunity(LikeDto likeDto);
    boolean appIsClickLikeOfStore(LikeDto likeDto);
}


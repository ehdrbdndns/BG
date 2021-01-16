package org.BG.Mapper;

import org.BG.DTO.AdvertiseDto;
import org.BG.DTO.AdvertiseV2Dto;

import java.util.ArrayList;

public interface AdvertiseMapper {
    ArrayList<AdvertiseDto> appGetAdvertiseOfChat();
    ArrayList<AdvertiseDto> appGetAdvertiseOfChatRoom();
    ArrayList<AdvertiseDto> appGetAdvertiseOfMainBanner();
    ArrayList<AdvertiseDto> appGetAdvertiseOfMainTop();
    ArrayList<AdvertiseDto> appGetAdvertiseOfMainBottom();
    ArrayList<AdvertiseDto> appGetAdvertiseOfChangeEat();
    ArrayList<AdvertiseDto> appGetAdvertiseOfOrderEat();
    ArrayList<AdvertiseDto> appGetAdvertiseOfShop();
    ArrayList<AdvertiseDto> appGetAdvertiseOfDetail();
    ArrayList<AdvertiseDto> appGetAdvertiseOfReview();
    ArrayList<AdvertiseDto> appGetAdvertiseOfCommunity();
    void appClickAdvertiseOfReview(AdvertiseDto advertiseDto);
    void appClickAdvertiseOfCommunity(AdvertiseDto advertiseDto);
    ArrayList<AdvertiseDto> countAdvertiseOfReview();
    ArrayList<AdvertiseDto> countAdvertiseOfCommunity();
    void uploadAdvertise(AdvertiseDto advertiseDto);
    void deleteAdvertise(AdvertiseDto advertiseDto);
    void deleteAdvertiseFromNo(AdvertiseDto advertiseDto);
    void uploadAdvertiseOfReview(AdvertiseDto advertiseDto);
    void uploadAdvertiseOfCommunity(AdvertiseDto advertiseDto);

    ArrayList<AdvertiseV2Dto> getAdvertiseV2();
    void uploadAdvertiseV2(AdvertiseV2Dto advertiseV2Dto);
    void deleteAdvertiseV2(AdvertiseV2Dto advertiseV2Dto);
    void appClickAdvertiseV2(AdvertiseV2Dto advertiseV2Dto);
}

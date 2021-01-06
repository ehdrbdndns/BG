package org.BG.Mapper;

import org.BG.DTO.AdvertiseDto;

import java.util.ArrayList;

public interface AdvertiseMapper {
    ArrayList<AdvertiseDto> appGetAdvertise();
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
}

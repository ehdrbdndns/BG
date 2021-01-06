package org.BG.Service.advertise;

import org.BG.DAO.AdvertiseDao;
import org.BG.DTO.AdvertiseDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdvertiseServiceImp implements AdvertiseService {
    @Autowired
    AdvertiseDao advertiseDao;

    @Override
    public JSONObject appGetAdvertise() {
        JSONObject result = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        try{
            ArrayList<AdvertiseDto> chatDto = new ArrayList<>();
            chatDto = advertiseDao.appGetAdvertiseOfChat();
            JSONArray chatItem = new JSONArray();
            for(int i = 0; i<chatDto.size(); i++){
                chatItem.add(chatDto.get(i).getAd_ChatList());
            }
            result.put("chat", chatItem);

            ArrayList<AdvertiseDto> chatRoomDto = new ArrayList<>();
            chatRoomDto = advertiseDao.appGetAdvertiseOfChatRoom();
            JSONArray chatRoomItem = new JSONArray();
            for(int i = 0; i<chatRoomDto.size(); i++){
                chatRoomItem.add(chatRoomDto.get(i).getAd_ChatRoom());
            }
            result.put("chatRoom", chatRoomItem);

            ArrayList<AdvertiseDto> mainBannerDto = new ArrayList<>();
            mainBannerDto = advertiseDao.appGetAdvertiseOfMainBanner();
            JSONArray mainBannerItem = new JSONArray();
            for(int i = 0; i<mainBannerDto.size(); i++){
                mainBannerItem.add(mainBannerDto.get(i).getAd_MainBanner());
            }
            result.put("mainBanner", mainBannerItem);

            ArrayList<AdvertiseDto> mainTop = new ArrayList<>();
            mainTop = advertiseDao.appGetAdvertiseOfMainTop();
            JSONArray mainTopItem = new JSONArray();
            for(int i = 0; i<mainTop.size(); i++){
                mainTopItem.add(mainTop.get(i).getAd_MainTop());
            }
            result.put("mainTop", mainTopItem);

            ArrayList<AdvertiseDto> mainBottom = new ArrayList<>();
            mainBottom = advertiseDao.appGetAdvertiseOfMainBottom();
            JSONArray mainBottomItem = new JSONArray();
            for(int i = 0; i<mainBottom.size(); i++){
                mainBottomItem.add(mainBottom.get(i).getAd_MainBottom());
            }
            result.put("mainBottom", mainBottomItem);

            ArrayList<AdvertiseDto> changeEat = new ArrayList<>();
            changeEat = advertiseDao.appGetAdvertiseOfChangeEat();
            JSONArray changeEatItem = new JSONArray();
            for(int i = 0; i<changeEat.size(); i++){
                changeEatItem.add(changeEat.get(i).getAd_Change());
            }
            result.put("changeEat", changeEatItem);

            ArrayList<AdvertiseDto> orderEat = new ArrayList<>();
            orderEat = advertiseDao.appGetAdvertiseOfOrderEat();
            JSONArray orderEatItem = new JSONArray();
            for(int i = 0; i<orderEat.size(); i++){
                orderEatItem.add(orderEat.get(i).getAd_Request());
            }
            result.put("orderEat", orderEatItem);

            ArrayList<AdvertiseDto> shop = new ArrayList<>();
            shop = advertiseDao.appGetAdvertiseOfShop();
            JSONArray shopItem = new JSONArray();
            for(int i = 0; i<shop.size(); i++){
                shopItem.add(shop.get(i).getAd_Shopin());
            }
            result.put("shop", shopItem);

            ArrayList<AdvertiseDto> detail = new ArrayList<>();
            detail = advertiseDao.appGetAdvertiseOfDetail();
            JSONArray detailItem = new JSONArray();
            for(int i = 0; i<detail.size(); i++){
                detailItem.add(detail.get(i).getAd_Details());
            }
            result.put("detail", detailItem);

            ArrayList<AdvertiseDto> review = new ArrayList<>();
            review = advertiseDao.appGetAdvertiseOfReview();
            JSONArray reviewItem = new JSONArray();
            for(int i = 0; i<review.size(); i++){
                reviewItem.add( (JSONArray) jsonParser.parse(review.get(i).getAd_Reviews()));
            }
            result.put("review", reviewItem);

            ArrayList<AdvertiseDto> community = new ArrayList<>();
            community = advertiseDao.appGetAdvertiseOfCommunity();
            JSONArray communityItem = new JSONArray();
            for(int i = 0; i<community.size(); i++){
                communityItem.add( (JSONArray) jsonParser.parse(community.get(i).getAd_Community()));
            }
            result.put("community", communityItem);

            System.out.println(result.toJSONString());

            return result;
        } catch (Exception e){
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public boolean appClickAdvertise(AdvertiseDto advertiseDto) {
        try{
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

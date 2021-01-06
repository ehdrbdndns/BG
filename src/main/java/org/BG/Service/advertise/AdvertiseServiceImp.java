package org.BG.Service.advertise;

import org.BG.DAO.AdvertiseDao;
import org.BG.DTO.AdvertiseDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
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
    @Autowired
    Aws_Cdn_Service aws_cdn_service;

    @Override
    public JSONObject appGetAdvertise() {
        JSONObject result = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        try {
            ArrayList<AdvertiseDto> chatDto = new ArrayList<>();
            chatDto = advertiseDao.appGetAdvertiseOfChat();
            JSONArray chatItem = new JSONArray();
            for (int i = 0; i < chatDto.size(); i++) {
                chatItem.add(chatDto.get(i).getAd_ChatList());
            }
            result.put("chat", chatItem);

            ArrayList<AdvertiseDto> chatRoomDto = new ArrayList<>();
            chatRoomDto = advertiseDao.appGetAdvertiseOfChatRoom();
            JSONArray chatRoomItem = new JSONArray();
            for (int i = 0; i < chatRoomDto.size(); i++) {
                chatRoomItem.add(chatRoomDto.get(i).getAd_ChatRoom());
            }
            result.put("chatRoom", chatRoomItem);

            ArrayList<AdvertiseDto> mainBannerDto = new ArrayList<>();
            mainBannerDto = advertiseDao.appGetAdvertiseOfMainBanner();
            JSONArray mainBannerItem = new JSONArray();
            for (int i = 0; i < mainBannerDto.size(); i++) {
                mainBannerItem.add(mainBannerDto.get(i).getAd_MainBanner());
            }
            result.put("mainBanner", mainBannerItem);

            ArrayList<AdvertiseDto> mainTop = new ArrayList<>();
            mainTop = advertiseDao.appGetAdvertiseOfMainTop();
            JSONArray mainTopItem = new JSONArray();
            for (int i = 0; i < mainTop.size(); i++) {
                mainTopItem.add(mainTop.get(i).getAd_MainTop());
            }
            result.put("mainTop", mainTopItem);

            ArrayList<AdvertiseDto> mainBottom = new ArrayList<>();
            mainBottom = advertiseDao.appGetAdvertiseOfMainBottom();
            JSONArray mainBottomItem = new JSONArray();
            for (int i = 0; i < mainBottom.size(); i++) {
                mainBottomItem.add(mainBottom.get(i).getAd_MainBottom());
            }
            result.put("mainBottom", mainBottomItem);

            ArrayList<AdvertiseDto> changeEat = new ArrayList<>();
            changeEat = advertiseDao.appGetAdvertiseOfChangeEat();
            JSONArray changeEatItem = new JSONArray();
            for (int i = 0; i < changeEat.size(); i++) {
                changeEatItem.add(changeEat.get(i).getAd_Change());
            }
            result.put("changeEat", changeEatItem);

            ArrayList<AdvertiseDto> orderEat = new ArrayList<>();
            orderEat = advertiseDao.appGetAdvertiseOfOrderEat();
            JSONArray orderEatItem = new JSONArray();
            for (int i = 0; i < orderEat.size(); i++) {
                orderEatItem.add(orderEat.get(i).getAd_Request());
            }
            result.put("orderEat", orderEatItem);

            ArrayList<AdvertiseDto> shop = new ArrayList<>();
            shop = advertiseDao.appGetAdvertiseOfShop();
            JSONArray shopItem = new JSONArray();
            for (int i = 0; i < shop.size(); i++) {
                shopItem.add(shop.get(i).getAd_Shopin());
            }
            result.put("shop", shopItem);

            ArrayList<AdvertiseDto> detail = new ArrayList<>();
            detail = advertiseDao.appGetAdvertiseOfDetail();
            JSONArray detailItem = new JSONArray();
            for (int i = 0; i < detail.size(); i++) {
                detailItem.add(detail.get(i).getAd_Details());
            }
            result.put("detail", detailItem);

            ArrayList<AdvertiseDto> review = new ArrayList<>();
            review = advertiseDao.appGetAdvertiseOfReview();
            JSONArray reviewItem = new JSONArray();
            for (int i = 0; i < review.size(); i++) {
                reviewItem.add((JSONObject) jsonParser.parse(review.get(i).getAd_Reviews()));
            }
            result.put("review", reviewItem);

            ArrayList<AdvertiseDto> community = new ArrayList<>();
            community = advertiseDao.appGetAdvertiseOfCommunity();
            JSONArray communityItem = new JSONArray();
            for (int i = 0; i < community.size(); i++) {
                communityItem.add((JSONObject) jsonParser.parse(community.get(i).getAd_Community()));
            }
            result.put("community", communityItem);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public JSONObject getAdvertise() {
        JSONObject result = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        try {
            ArrayList<AdvertiseDto> chatDto = new ArrayList<>();
            chatDto = advertiseDao.appGetAdvertiseOfChat();
            JSONArray chatItem = new JSONArray();
            for (int i = 0; i < chatDto.size(); i++) {
                chatItem.add(chatDto.get(i).getAd_ChatList());
            }
            result.put("chat", chatItem);

            ArrayList<AdvertiseDto> chatRoomDto = new ArrayList<>();
            chatRoomDto = advertiseDao.appGetAdvertiseOfChatRoom();
            JSONArray chatRoomItem = new JSONArray();
            for (int i = 0; i < chatRoomDto.size(); i++) {
                chatRoomItem.add(chatRoomDto.get(i).getAd_ChatRoom());
            }
            result.put("chatRoom", chatRoomItem);

            ArrayList<AdvertiseDto> mainBannerDto = new ArrayList<>();
            mainBannerDto = advertiseDao.appGetAdvertiseOfMainBanner();
            JSONArray mainBannerItem = new JSONArray();
            for (int i = 0; i < mainBannerDto.size(); i++) {
                mainBannerItem.add(mainBannerDto.get(i).getAd_MainBanner());
            }
            result.put("mainBanner", mainBannerItem);

            ArrayList<AdvertiseDto> mainTop = new ArrayList<>();
            mainTop = advertiseDao.appGetAdvertiseOfMainTop();
            JSONArray mainTopItem = new JSONArray();
            for (int i = 0; i < mainTop.size(); i++) {
                mainTopItem.add(mainTop.get(i).getAd_MainTop());
            }
            result.put("mainTop", mainTopItem);

            ArrayList<AdvertiseDto> mainBottom = new ArrayList<>();
            mainBottom = advertiseDao.appGetAdvertiseOfMainBottom();
            JSONArray mainBottomItem = new JSONArray();
            for (int i = 0; i < mainBottom.size(); i++) {
                mainBottomItem.add(mainBottom.get(i).getAd_MainBottom());
            }
            result.put("mainBottom", mainBottomItem);

            ArrayList<AdvertiseDto> changeEat = new ArrayList<>();
            changeEat = advertiseDao.appGetAdvertiseOfChangeEat();
            JSONArray changeEatItem = new JSONArray();
            for (int i = 0; i < changeEat.size(); i++) {
                changeEatItem.add(changeEat.get(i).getAd_Change());
            }
            result.put("changeEat", changeEatItem);

            ArrayList<AdvertiseDto> orderEat = new ArrayList<>();
            orderEat = advertiseDao.appGetAdvertiseOfOrderEat();
            JSONArray orderEatItem = new JSONArray();
            for (int i = 0; i < orderEat.size(); i++) {
                orderEatItem.add(orderEat.get(i).getAd_Request());
            }
            result.put("orderEat", orderEatItem);

            ArrayList<AdvertiseDto> shop = new ArrayList<>();
            shop = advertiseDao.appGetAdvertiseOfShop();
            JSONArray shopItem = new JSONArray();
            for (int i = 0; i < shop.size(); i++) {
                shopItem.add(shop.get(i).getAd_Shopin());
            }
            result.put("shop", shopItem);

            ArrayList<AdvertiseDto> detail = new ArrayList<>();
            detail = advertiseDao.appGetAdvertiseOfDetail();
            JSONArray detailItem = new JSONArray();
            for (int i = 0; i < detail.size(); i++) {
                detailItem.add(detail.get(i).getAd_Details());
            }
            result.put("detail", detailItem);

            ArrayList<AdvertiseDto> review = new ArrayList<>();
            review = advertiseDao.appGetAdvertiseOfReview();
            JSONArray reviewItem = new JSONArray();
            for (int i = 0; i < review.size(); i++) {
                JSONObject object = (JSONObject) jsonParser.parse(review.get(i).getAd_Reviews());
                object.put("no", review.get(i).getAd_No());
                reviewItem.add(object);
            }
            result.put("review", reviewItem);

            ArrayList<AdvertiseDto> community = new ArrayList<>();
            community = advertiseDao.appGetAdvertiseOfCommunity();
            JSONArray communityItem = new JSONArray();
            for (int i = 0; i < community.size(); i++) {
                JSONObject object = (JSONObject) jsonParser.parse(community.get(i).getAd_Community());
                object.put("no", community.get(i).getAd_No());
                communityItem.add(object);
            }
            result.put("community", communityItem);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public boolean appClickAdvertise(AdvertiseDto advertiseDto) {
        JSONParser parser = new JSONParser();
        try {
            if (advertiseDto.getAd_Type().equals("review")) {
                ArrayList<AdvertiseDto> advertiseDtoArrayList = advertiseDao.appGetAdvertiseOfReview();
                for (int i = 0; i < advertiseDtoArrayList.size(); i++) {
                    JSONObject jsonObject = (JSONObject) parser.parse(advertiseDtoArrayList.get(i).getAd_Reviews());
                    if(jsonObject.get("url").equals(advertiseDto.getAd_Url())){
                        advertiseDto.setAd_No(advertiseDtoArrayList.get(i).getAd_No());
                        return advertiseDao.appClickAdvertiseOfReview(advertiseDto);
                    } else {
                        System.out.println("review wrong url");
                        System.out.println(advertiseDto.getAd_Url());
                        System.out.println(jsonObject.get("url"));
                        return false;
                    }
                }
            } else if (advertiseDto.getAd_Type().equals("community")) {
                ArrayList<AdvertiseDto> advertiseDtoArrayList = advertiseDao.appGetAdvertiseOfCommunity();
                for (int i = 0; i < advertiseDtoArrayList.size(); i++) {
                    JSONObject jsonObject = (JSONObject) parser.parse(advertiseDtoArrayList.get(i).getAd_Community());
                    if(jsonObject.get("url").equals(advertiseDto.getAd_Url())){
                        advertiseDto.setAd_No(advertiseDtoArrayList.get(i).getAd_No());
                        return advertiseDao.appClickAdvertiseOfCommunity(advertiseDto);
                    } else {
                        System.out.println("community wrong url");
                        System.out.println(advertiseDto.getAd_Url());
                        System.out.println(jsonObject.get("url"));
                        return false;
                    }
                }
            } else {
                System.out.println("Ad_Type err: " + advertiseDto.getAd_Type());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public JSONArray countAdvertise() {
        JSONArray result = new JSONArray();
        JSONParser parser = new JSONParser();
        try{
            ArrayList<AdvertiseDto> reviewDto = advertiseDao.countAdvertiseOfReview();
            ArrayList<AdvertiseDto> communityDto = advertiseDao.countAdvertiseOfCommunity();

            //리뷰 광고
            for(int i = 0; i < reviewDto.size(); i++){
                JSONObject reviewJSON = (JSONObject) parser.parse(reviewDto.get(i).getAd_Reviews());
                result.add(reviewJSON.get("title"));
                result.add(reviewDto.get(i).getAd_ReviewsCon());
            }

            //커뮤니티 광고
            for(int i = 0; i < communityDto.size(); i++){
                JSONObject communityJSON = (JSONObject) parser.parse(communityDto.get(i).getAd_Community());
                result.add(communityJSON.get("title"));
                result.add(communityDto.get(i).getAd_CommunityCount());
            }

            return result;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void uploadAdvertise(AdvertiseDto advertiseDto) {
        JSONObject object = new JSONObject();
        try{
            if(advertiseDto.getAd_Type().equals("Ad_Reviews")){
                object.put("title", advertiseDto.getAd_Title());
                object.put("desc", advertiseDto.getAd_Desc());
                object.put("link", advertiseDto.getAd_Link());
                object.put("url", aws_cdn_service.FileUpload("advertise/"+advertiseDto.getAd_Type()+"/", advertiseDto.getAd_File()));
                advertiseDto.setAd_Reviews(object.toJSONString());
                advertiseDao.uploadAdvertiseOfReview(advertiseDto);
            } else if (advertiseDto.getAd_Type().equals("Ad_Community")) {
                object.put("title", advertiseDto.getAd_Title());
                object.put("desc", advertiseDto.getAd_Desc());
                object.put("link", advertiseDto.getAd_Link());
                object.put("url", aws_cdn_service.FileUpload("advertise/"+advertiseDto.getAd_Type()+"/", advertiseDto.getAd_File()));
                advertiseDto.setAd_Community(object.toJSONString());
                advertiseDao.uploadAdvertiseOfCommunity(advertiseDto);
            } else{
                String Ad_Url = aws_cdn_service.FileUpload("advertise/"+advertiseDto.getAd_Type()+"/", advertiseDto.getAd_File());
                advertiseDto.setAd_Url(Ad_Url);
                advertiseDao.uploadAdvertise(advertiseDto);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdvertise(AdvertiseDto advertiseDto) {
        try{
            aws_cdn_service.FileDelete(advertiseDto.getAd_Url());
            advertiseDao.deleteAdvertise(advertiseDto);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdvertiseFromNo(AdvertiseDto advertiseDto) {
        try{
            aws_cdn_service.FileDelete(advertiseDto.getAd_Url());
            advertiseDao.deleteAdvertiseFromNo(advertiseDto);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

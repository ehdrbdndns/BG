package org.BG.Service.home;

import org.BG.DAO.*;
import org.BG.DTO.*;
import org.BG.util.geocoder.Geocoder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class HomeServiceImp implements HomeService {
    @Autowired
    Geocoder geocoder;
    @Autowired
    HomeDao homeDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    StoreDao storeDao;
    @Autowired
    InquiryDao inquiryDao;
    @Autowired
    ReplyDao replyDao;

    @Override
    public JSONArray appRetrieveShopList(HomeDto homeDto){
        JSONArray result = new JSONArray();
        try {
            //리스트 index 변경
            homeDto.setLastIndex(homeDto.getFirstIndex() + 10);

            //위도 경도 값 추출
            Double[] coords = geocoder.getLatitude(homeDto.getLocation());
            if(coords == null){
                JSONArray err = new JSONArray();
                err.add("geocoder_Err");
                return err;
            }
            homeDto.setLat(coords[0]);
            homeDto.setLng(coords[1]);

            String search = "";
            search = homeDto.getSearch();
            if (homeDto.getSearch().equals("")) {
                search = "%%";
            } else {
                search = "%" + search + "%";
            }
            homeDto.setSearch(search);

            String ways = "";
            if (homeDto.getWays().equals("all")) {
                ways = "%%";
            } else {
                ways = "%" + homeDto.getWays() + "%";
            }
            homeDto.setWays(ways);

            System.out.println("FirstIndex: " + homeDto.getFirstIndex());
            System.out.println("LastIndex: " + homeDto.getLastIndex());
            ArrayList<HomeDto> homeDtoArrayList = homeDao.appRetrieveStoreInfoOfLatitude(homeDto);
            System.out.println("size: " + homeDtoArrayList.size());

            result.add(homeDto.getLastIndex());
            if (homeDto.getCategory().equals("change") || homeDto.getCategory().equals("call")) {
                //바꿔머거
                for (int i = 0; i < homeDtoArrayList.size(); i++) {
                    JSONObject item = new JSONObject();

                    homeDto.setUser_No(homeDtoArrayList.get(i).getUser_No());

                    HomeDto homeItem = new HomeDto();
                    homeItem = homeDao.appRetrieveShopListVerStore(homeDto);

                    if (homeItem != null) {
                        homeItem.setDistance(homeDtoArrayList.get(i).getDistance());
                        item.put("key", homeItem.getStore_No());
                        item.put("img", homeItem.getStore_Img());
                        item.put("name", homeItem.getUser_ComNm());
                        item.put("distance", homeItem.getDistance());
                        item.put("address", homeItem.getUser_Addr());
                        item.put("foodCategory", homeItem.getStore_Category());
                        item.put("regDate", homeItem.getUser_RegDate());
                        item.put("foodName", homeItem.getStore_Desc());
                        item.put("mainMenu", homeItem.getStore_MainMenu());

                        result.add(item);
                    }
                }
            } else if (homeDto.getCategory().equals("shopin")) {
                //샵인 샵
                for (int i = 0; i < homeDtoArrayList.size(); i++) {
                    JSONObject item = new JSONObject();

                    homeDto.setUser_No(homeDtoArrayList.get(i).getUser_No());

                    HomeDto homeItem = new HomeDto();

                    homeItem = homeDao.appRetrieveShopListVerSIS(homeDto);

                    if (homeItem != null) {
                        homeItem.setDistance(homeDtoArrayList.get(i).getDistance());
                        item.put("key", homeItem.getStore_No());
                        item.put("img", homeItem.getShopin_Img());
                        item.put("name", homeItem.getShopin_Name());
                        item.put("distance", homeItem.getDistance());
                        item.put("address", homeItem.getUser_Addr());
                        item.put("foodCategory", homeItem.getShopin_Category());
                        item.put("regDate", homeItem.getUser_RegDate());
                        item.put("foodName", homeItem.getStore_Desc());
                        item.put("mainMenu", homeItem.getStore_MainMenu());

                        result.add(item);
                    }
                }
            } else {
                System.out.println("appRetrieveShopList err category: " + homeDto.getCategory());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("요로쿰");
            return null;
        }
        return result;
    }

    @Override
    public JSONObject appRetrieveShopDetail(HomeDto homeDto) {
        JSONObject result = new JSONObject();
        try {
            StoreDto storeDto = new StoreDto();
            storeDto.setStore_No(homeDto.getStore_No());
            storeDto = storeDao.appRetrieveUserStoreVerStoreOfStoreNo(storeDto);
            homeDto.setUser_No(storeDto.getUser_No());
            result.put("ways", storeDto.getStore_Ways());
            result.put("desc", storeDto.getStore_Desc());
            result.put("likes", storeDto.getStore_Likes());
            result.put("lat", storeDto.getUser_Lat());
            result.put("lng", storeDto.getUser_Lng());

            ArrayList<ProductDto> productDtos = productDao.appRetrieveProductVerStore(homeDto.getStore_No());
            JSONArray productList = new JSONArray();
            for (int i = 0; i < productDtos.size(); i++) {
                JSONObject item = new JSONObject();
                item.put("key", productDtos.get(i).getProduct_No());
                item.put("name", productDtos.get(i).getProduct_Name());
                item.put("img", productDtos.get(i).getProduct_Img());
                item.put("price", productDtos.get(i).getProduct_Price());
                item.put("sales", productDtos.get(i).getProduct_Sales());
                item.put("compo", productDtos.get(i).getProduct_Compo());
                item.put("type", productDtos.get(i).getProduct_Type());
                productList.add(item);
            }
            result.put("productList", productList);

            ReplyDto replyDto = new ReplyDto();
            replyDto.setStore_No(homeDto.getStore_No());
            ArrayList<ReplyDto> replyDtos = replyDao.appRetrieveReviews(replyDto);
            JSONArray reply = new JSONArray();

            reply.add(homeDto.getUser_No());
            for(int i = 0; i<replyDtos.size(); i++){
                replyDto.setReviews_No(replyDtos.get(i).getReviews_No());
                ReplyDto reply_reply = replyDao.appRetrieveReviewsOfReviews(replyDto);
                JSONObject item = new JSONObject();
                item.put("reply_no", replyDtos.get(i).getReviews_No());
                item.put("content", replyDtos.get(i).getReviews_Comments());
                item.put("regDate", replyDtos.get(i).getReviews_RegDate());
                item.put("userName", replyDtos.get(i).getUser_Name());
                item.put("userImg", replyDtos.get(i).getStore_Img());
                if(reply_reply != null){
                    item.put("reply_userName", reply_reply.getRR_UserName());
                    item.put("reply_userImg", reply_reply.getRR_StoreImg());
                    item.put("reply_content", reply_reply.getRR_Comments());
                    item.put("reply_regDate", reply_reply.getRR_RegDate());
                } else{
                    item.put("reply_userName", null);
                    item.put("reply_userImg", null);
                    item.put("reply_content", null);
                    item.put("reply_regDate", null);
                }
                reply.add(item);
            }
            result.put("review", reply);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONArray getVisitorCount(String dayType) {
        JSONArray result = new JSONArray();
        try {
            if (dayType == null) {
                result = getTodayVisitorCount("visitor");
            } else if (dayType.equals("oneWeek")) {
                result = getWeekVisitorCount("visitor");
            } else if (dayType.equals("oneMonth")) {
                result = getMonthVisitorCount(-1, "visitor");
            } else if (dayType.equals("threeMonth")) {
                result = getMonthVisitorCount(-3, "visitor");
            } else if (dayType.equals("sixMonth")) {
                result = getMonthVisitorCount(-6, "visitor");
            } else if (dayType.equals("oneYear")) {
                result = getMonthVisitorCount(-12, "visitor");
            } else {
                System.out.println("Warning Visitor Category: " + dayType);
                return null;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONArray getRegisterCount(String dayType) {
        JSONArray result = new JSONArray();
        try {
            if (dayType == null) {
                result = getTodayVisitorCount("register");
            } else if (dayType.equals("oneWeek")) {
                result = getWeekVisitorCount("register");
            } else if (dayType.equals("oneMonth")) {
                result = getMonthVisitorCount(-1, "register");
            } else if (dayType.equals("threeMonth")) {
                result = getMonthVisitorCount(-3, "register");
            } else if (dayType.equals("sixMonth")) {
                result = getMonthVisitorCount(-6, "register");
            } else if (dayType.equals("oneYear")) {
                result = getMonthVisitorCount(-12, "register");
            } else {
                System.out.println("Warning register Category: " + dayType);
                return null;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<UserDto> getNewUserInfoList() {
        try{
            String date = getToday();
            return homeDao.getNewUserInfoList(date);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appClickLikeBtn(LikeDto likeDto) {
        try{
            if (likeDto.getLike_Type().equals("community")){
                likeDto.setCommunity_No(likeDto.getBoard_No());
                likeDto.setStore_No(0);
                if(!homeDao.appIsClickLikeOfCommunity(likeDto)){
                    //좋아요 버튼을 누르지 않은 경우
                    homeDao.appPlusLikeOfCommunity(likeDto);
                    return homeDao.appInsertLikeOfCommunity(likeDto);
                } else{
                    //좋아요 버튼을 눌렀을 경우
                    return homeDao.appMinusLikeOfCommunity(likeDto);
                }
            } else if(likeDto.getLike_Type().equals("store")){
                likeDto.setStore_No(likeDto.getBoard_No());
                likeDto.setCommunity_No(0);
                if(!homeDao.appIsClickLikeOfStore(likeDto)){
                    //좋아요 버튼을 누르지 않은 경우
                    homeDao.appPlusLikeOfStore(likeDto);
                    return homeDao.appInsertLikeOfStore(likeDto);
                } else{
                    //좋아요 버튼을 눌렀을 경우
                    return homeDao.appMinusLikeOfStore(likeDto);
                }
            } else {
                System.out.println("appClickLikeBtn Category x: " + likeDto.getLike_Type());
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appIsClickLike(LikeDto likeDto) {
        try{
            if (likeDto.getLike_Type().equals("community")){
                likeDto.setCommunity_No(likeDto.getBoard_No());
                System.out.println("Community_No: " + likeDto.getCommunity_No());
                System.out.println("User_No: " + likeDto.getUser_No());
                if(homeDao.appIsClickLikeOfCommunity(likeDto)){
                    System.out.println("gg");
                    return "true";
                } else{
                    System.out.println("ll");
                    return "false";
                }
            } else if(likeDto.getLike_Type().equals("store")){
                likeDto.setStore_No(likeDto.getBoard_No());
                if(homeDao.appIsClickLikeOfStore(likeDto)){
                    return "true";
                } else{
                    return "false";
                }
            } else {
                System.out.println("appClickLikeBtn Category x: " + likeDto.getLike_Type());
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    public JSONArray getTodayVisitorCount(String countType) {
        JSONArray result = new JSONArray();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            try {
                if (i != 0)
                    cal.add(Calendar.DATE, -1);
                String date = df.format(cal.getTime());

                result.add(date);
                if (countType.equals("visitor")) {
                    result.add(homeDao.getTodayVisitorCount(date));
                } else {
                    result.add(homeDao.getTodayRegisterCount(date));
                }
            } catch (NullPointerException e) {
                result.add(0);
            }
        }
        return result;
    }

    public JSONArray getWeekVisitorCount(String countType) {
        JSONArray result = new JSONArray();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 11; i++) {
            try {
                if (i == 0) {
                    Calendar Csunday = Calendar.getInstance();
                    Csunday.setTime(new Date());

                    Calendar Ctoday = Calendar.getInstance();
                    Csunday.setTime(new Date());

                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    Csunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                    String sunday = dateFormat.format(Csunday.getTime());

                    String today = dateFormat.format(Ctoday.getTime());
                    if (sunday.equals(today)) {
                        cal.add(Calendar.DATE, -1);
                    }
                } else {
                    cal.add(Calendar.DATE, -14);
                }
                cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                String startDate = df.format(cal.getTime());
                cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                cal.add(Calendar.DATE, 7);
                String endDate = df.format(cal.getTime());

                result.add(startDate + "~" + endDate);
                if (countType.equals("visitor")) {
                    result.add(homeDao.getAnywayVisitorCount(startDate, endDate));
                } else {
                    result.add(homeDao.getAnywayRegisterCount(startDate, endDate));
                }
            } catch (NullPointerException e) {
                result.add(0);
            }
        }
        return result;
    }

    public JSONArray getMonthVisitorCount(int dateCount, String countType) {
        JSONArray result = new JSONArray();
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            try {
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, dateCount*i);
                String endDate = df.format(cal.getTime());
                cal.add(Calendar.MONTH, dateCount);
                String startDate = df.format(cal.getTime());

                result.add(endDate + "~" + startDate);
                if (countType.equals("visitor")) {
                    result.add(homeDao.getAnywayVisitorCount(startDate, endDate));
                } else {
                    result.add(homeDao.getAnywayRegisterCount(startDate, endDate));
                }
            } catch (NullPointerException e) {
                result.add(0);
            }
        }
        return result;
    }

    public JSONArray getYearVisitorCount(int dateCount, String countType) {
        JSONArray result = new JSONArray();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            try {
                if (i != 0)
                    cal.add(Calendar.DATE, cal.getMaximum(Calendar.DAY_OF_YEAR) * dateCount);
                cal.set(Calendar.DATE, cal.getMinimum(Calendar.DAY_OF_YEAR));
                String startDate = df.format(cal.getTime());
                cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
                String endDate = df.format(cal.getTime());

                result.add(startDate + "~" + endDate);
                if (countType.equals("visitor")) {
                    result.add(homeDao.getAnywayVisitorCount(startDate, endDate));
                } else {
                    result.add(homeDao.getAnywayRegisterCount(startDate, endDate));
                }
            } catch (NullPointerException e) {
                result.add(0);
            }
        }
        return result;
    }
}

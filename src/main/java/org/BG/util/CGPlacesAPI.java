//package org.BG.util;
//
//import net.sf.json.JSONException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.ArrayList;
//
//@Service
//public class CGPlacesAPI {
//    StringBuilder mResponseBuilder = new StringBuilder();
//    String key = "AIzaSyBfBZB4jgWgkU6HUqk4XGMof8Zb1xZYoQ0";
//    ArrayList<String> stringArrayList = new ArrayList<>();
//
//    public ArrayList<String> parsing(String _lat, String _lon, String _radius, String _type, String language) {
//        try {
//            String uStr = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + _lat + "," + _lon + "&radius=" + _radius + "&types=" + _type + "&language="+ language +"&key=" + key;
//            URL url = new URL(uStr);
//            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//            String inputLine;
//
//            while ((inputLine = in.readLine()) != null) {
//                mResponseBuilder.append(inputLine);
//            }
//            in.close();
//            JSONArray jArr;
//            JSONObject jObj;
//
//            jObj = (JSONObject) mResponseBuilder.toString();
////            jObj = new JSONObject();
////            jObj.put("result", mResponseBuilder.toString());
////            jArr = (JSONArray) jObj.get("results");
//
//            System.out.println("------");
//            System.out.println(mResponseBuilder.toString());
//            System.out.println("------");
//            System.out.println(jObj.toString());
//            System.out.println("------");
//            System.out.println(jArr);
//
//            for (int i = 0; i < jArr.size(); i++) {
//                // 결과별로 결과 object 얻기
//                JSONObject result = (JSONObject) jArr.get(i);
//
//                // 위도, 경도 얻기
//                JSONObject geo = (JSONObject) result.get("geometry");
//                JSONObject location = (JSONObject) geo.get("location");
//                String sLat = (String) location.get("lat");
//                String sLon = (String) location.get("lng");
//
//                // 이름 얻기
//                String name = (String) result.get("name");
//
//                // Rating 얻기
//                String rating = "0";
//                if (Integer.parseInt((String) result.get("rating")) > 0) {
//                    rating = (String) result.get("rating");
//                }
//
//                stringArrayList.add(rating);
//                stringArrayList.add(sLat);
//                stringArrayList.add(sLon);
//                stringArrayList.add(name);
//            }
//        } catch (JSONException | IOException e) {
//            e.printStackTrace();
//        }
//        return stringArrayList;
//    }
//
//}

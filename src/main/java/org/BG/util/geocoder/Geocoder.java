package org.BG.util.geocoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Service
public class Geocoder {
    public Double[] getLatitude(String location) {
        JSONParser jsonParser = new JSONParser();
//        String key = "AIzaSyBfBZB4jgWgkU6HUqk4XGMof8Zb1xZYoQ0";
        String key = "AIzaSyAA9m2kbA2IQWrfc3Nqf-7ERe9TaqmwZyE";
        BufferedReader in = null;
        try {
            String jsonString = new String();
            location = URLEncoder.encode(location, "UTF-8");
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address="+location+"&key="+key); // 호출할 url
            URLConnection conn = url.openConnection();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) { // response를 차례대로 출력
                jsonString += line;
            }

            JSONObject obj = (JSONObject) jsonParser.parse(jsonString);
            JSONArray arry = (JSONArray) jsonParser.parse(obj.get("results").toString());
            obj = (JSONObject) jsonParser.parse(arry.get(0).toString());
            obj = (JSONObject) jsonParser.parse(obj.get("geometry").toString());
            JSONObject locationObject = (JSONObject) jsonParser.parse(obj.get("location").toString());

            Double[] coords = new Double[2];
            coords[0] = (Double) locationObject.get("lat");
            coords[1] = (Double) locationObject.get("lng");

            System.out.println("위도: " + coords[0]);
            System.out.println("경도: " + coords[1]);

            return coords;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

package org.BG.util.geocoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GpsToAddress {
    double latitude;
    double longitude;
    String regionAddress;
    String key = "AIzaSyAA9m2kbA2IQWrfc3Nqf-7ERe9TaqmwZyE";

    public GpsToAddress(double latitude, double longitude) throws Exception {
        this.latitude = latitude;
        this.longitude = longitude;
        this.regionAddress = getRegionAddress(getJSONData(getApiAddress()));
    }

    private String getApiAddress() {
        String apiURL = "https://maps.googleapis.com/maps/api/geocode/json?latlng="
                + latitude + "," + longitude + "&language=ko&key="+key;
        return apiURL;
    }

    private String getJSONData(String apiURL) throws Exception {
        String jsonString = new String();
        String buf;
        URL url = new URL(apiURL);
        URLConnection conn = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        while ((buf = br.readLine()) != null) {
            jsonString += buf;
        }
        System.out.println("jsonString: " + jsonString);
        return jsonString;
    }

    private String getRegionAddress(String jsonString) {
        JSONObject jObj = (JSONObject) JSONValue.parse(jsonString);
        JSONArray jArray = (JSONArray) jObj.get("results");
        jObj = (JSONObject) jArray.get(1);
        return (String) jObj.get("formatted_address");
    }

    public String getAddress() {
        return regionAddress;
    }
}

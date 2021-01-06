package org.BG.Service.advertise;

import org.BG.DTO.AdvertiseDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface AdvertiseService {
    JSONObject appGetAdvertise();
    JSONObject getAdvertise();
    boolean appClickAdvertise(AdvertiseDto advertiseDto);
    JSONArray countAdvertise();
    void uploadAdvertise(AdvertiseDto advertiseDto);
    void deleteAdvertise(AdvertiseDto advertiseDto);
    void deleteAdvertiseFromNo(AdvertiseDto advertiseDto);
}

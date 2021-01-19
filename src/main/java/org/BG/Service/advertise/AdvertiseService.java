package org.BG.Service.advertise;

import org.BG.DTO.AdvertiseDto;
import org.BG.DTO.AdvertiseV2Dto;
import org.BG.DTO.AdvertiseV3Dto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface AdvertiseService {
    ArrayList<AdvertiseV3Dto> getAdvertiseV3();
    void uploadAdvertiseV3(AdvertiseV3Dto advertiseV3Dto);
    void deleteAdvertiseV3(AdvertiseV3Dto advertiseV3Dto);
    AdvertiseV3Dto retrieveAdvertiseV3(AdvertiseV3Dto advertiseV3Dto);

    //광고 두번째
    JSONObject getAdvertiseV2();
    void uploadAdvertiseV2(AdvertiseV2Dto advertiseDto);
    void deleteAdvertiseV2(AdvertiseV2Dto advertiseV2Dto);
    void appClickAdvertiseV2(AdvertiseV2Dto advertiseV2Dto);
    JSONArray countAdvertiseV2();

    //광고 첫번째
    JSONObject appGetAdvertise();
    JSONObject getAdvertise();
    boolean appClickAdvertise(AdvertiseDto advertiseDto);
    JSONArray countAdvertise();
    void uploadAdvertise(AdvertiseDto advertiseDto);
    void deleteAdvertise(AdvertiseDto advertiseDto);
    void deleteAdvertiseFromNo(AdvertiseDto advertiseDto);
}

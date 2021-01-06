package org.BG.Service.advertise;

import org.BG.DTO.AdvertiseDto;
import org.json.simple.JSONObject;

public interface AdvertiseService {
    JSONObject appGetAdvertise();
    boolean appClickAdvertise(AdvertiseDto advertiseDto);
}

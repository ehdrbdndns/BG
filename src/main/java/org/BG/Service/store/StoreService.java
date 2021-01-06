package org.BG.Service.store;

import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface StoreService {
    JSONObject appRetrieveUserStore(UserDto userDto);
    String appSaveUserStore(StoreDto storeDto);
    StoreDto getStoreInfo(UserDto userDto);
    JSONObject countStoreOfType();
}

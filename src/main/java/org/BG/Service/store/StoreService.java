package org.BG.Service.store;

import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONObject;

public interface StoreService {
    JSONObject appRetrieveUserStore(UserDto userDto);
    String appSaveUserStore(StoreDto storeDto);
    StoreDto getStoreInfo(UserDto userDto);
}

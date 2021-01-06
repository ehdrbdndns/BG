package org.BG.Service.sis;

import org.BG.DTO.ShopinDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface SISService {
    JSONArray appRetrieveUserSISList(UserDto userDto);
    String appSaveUserSIS(ShopinDto shopinDto);
    JSONObject appRetrieveUserSIS(ShopinDto shopinDto);
    String appDeleteUserSIS(ShopinDto shopinDto);
}

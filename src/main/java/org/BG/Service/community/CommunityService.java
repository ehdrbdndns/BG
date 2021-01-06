package org.BG.Service.community;

import org.BG.DTO.CommunityDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public interface CommunityService {
    JSONArray appRetrieveCommunityListOfMy(UserDto userDto);
    String appMakeCommunityOfMy(CommunityDto communityDto);
    JSONObject appRetrieveCommunityOfMy(CommunityDto communityDto);
    String appDeleteCommunityOfMy(CommunityDto communityDto);
    String appModifyCommunityOfMy(CommunityDto communityDto);
    JSONArray appRetrieveCommunityListOfMain(CommunityDto communityDto);
    JSONArray appRetrieveCommunityDetailOfMain(CommunityDto communityDto);
    ArrayList<CommunityDto> getCommunityList();
    CommunityDto getCommunityInfo(CommunityDto communityDto);
}

package org.BG.Mapper;

import org.BG.DTO.CommunityDto;
import org.BG.DTO.UserDto;

import java.util.ArrayList;

public interface CommunityMapper {
    ArrayList<CommunityDto> appRetrieveCommunityListOfMy(UserDto userDto);
    void appMakeCommunityOfMy(CommunityDto communityDto);
    CommunityDto appRetrieveCommunityOfMy(CommunityDto communityDto);
    void appDeleteCommunityOfMy(CommunityDto communityDto);
    void appModifyCommunityOfMy(CommunityDto communityDto);
    ArrayList<CommunityDto> appRetrieveCommunityListOfMainNew(CommunityDto communityDto);
    ArrayList<CommunityDto> appRetrieveCommunityListOfMainBest(CommunityDto communityDto);
    ArrayList<CommunityDto> appRetrieveCommunityListOfMainView(CommunityDto communityDto);
    ArrayList<CommunityDto> getCommunityList();
    int countCommunityReply(CommunityDto communityDto);
    CommunityDto getCommunityInfo(CommunityDto communityDto);
    void deleteCommunity(CommunityDto communityDto);
    void increaseCommunityView(CommunityDto communityDto);
}

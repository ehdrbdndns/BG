package org.BG.DAO;

import org.BG.DTO.CommunityDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.CommunityMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CommunityDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<CommunityDto> appRetrieveCommunityListOfMy(UserDto userDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.appRetrieveCommunityListOfMy(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appMakeCommunityOfMy(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            communityMapper.appMakeCommunityOfMy(communityDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public CommunityDto appRetrieveCommunityOfMy(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.appRetrieveCommunityOfMy(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appDeleteCommunityOfMy(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            communityMapper.appDeleteCommunityOfMy(communityDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appModifyCommunityOfMy(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            communityMapper.appModifyCommunityOfMy(communityDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<CommunityDto> appRetrieveCommunityListOfMainNew(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.appRetrieveCommunityListOfMainNew(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<CommunityDto> appRetrieveCommunityListOfMainBest(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.appRetrieveCommunityListOfMainBest(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<CommunityDto> appRetrieveCommunityListOfMainView(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.appRetrieveCommunityListOfMainView(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<CommunityDto> getCommunityList(){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.getCommunityList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int countCommunityReply(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.countCommunityReply(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public CommunityDto getCommunityInfo(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            return communityMapper.getCommunityInfo(communityDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteCommunity(CommunityDto communityDto){
        try{
            CommunityMapper communityMapper = sqlSession.getMapper(CommunityMapper.class);
            communityMapper.deleteCommunity(communityDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

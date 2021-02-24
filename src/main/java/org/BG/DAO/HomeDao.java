package org.BG.DAO;

import org.BG.DTO.HomeDto;
import org.BG.DTO.LikeDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.HomeMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class HomeDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<HomeDto> appRetrieveStoreInfoOfLatitude(HomeDto homeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.appRetrieveStoreInfoOfLatitude(homeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HomeDto> appRetrieveSISInfoOfLatitude(HomeDto homeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.appRetrieveSISInfoOfLatitude(homeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HomeDto appRetrieveShopListVerStore(HomeDto homeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.appRetrieveShopListVerStore(homeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HomeDto appRetrieveShopListVerSIS(HomeDto homeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.appRetrieveShopListVerSIS(homeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getTodayVisitorCount(String date) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.getTodayVisitorCount(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getAnywayVisitorCount(String startDate, String endDate) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.getAnywayVisitorCount(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getTodayRegisterCount(String date) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.getTodayRegisterCount(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getAnywayRegisterCount(String startDate, String endDate) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.getAnywayRegisterCount(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<UserDto> getNewUserInfoList(String date) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.getNewUserInfoList(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String appPlusLikeOfCommunity(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            homeMapper.appPlusLikeOfCommunity(likeDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String appPlusLikeOfStore(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            homeMapper.appPlusLikeOfStore(likeDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String appInsertLikeOfCommunity(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            homeMapper.appInsertLikeOfCommunity(likeDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String appInsertLikeOfStore(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            homeMapper.appInsertLikeOfStore(likeDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean appIsClickLikeOfCommunity(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.appIsClickLikeOfCommunity(likeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean appIsClickLikeOfStore(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            return homeMapper.appIsClickLikeOfStore(likeDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String appMinusLikeOfCommunity(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            homeMapper.appMinusLikeOfCommunity(likeDto);
            homeMapper.appDeleteLikeOfCommunity(likeDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String appMinusLikeOfStore(LikeDto likeDto) {
        try {
            HomeMapper homeMapper = sqlSession.getMapper(HomeMapper.class);
            homeMapper.appMinusLikeOfStore(likeDto);
            homeMapper.appDeleteLikeOfStore(likeDto);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

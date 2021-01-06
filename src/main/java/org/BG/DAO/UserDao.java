package org.BG.DAO;

import org.BG.DTO.ProductDto;
import org.BG.DTO.ShopinDto;
import org.BG.DTO.StoreDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;

    public UserDto appRetrieveUserInfo(UserDto userDto){
        UserDto userDto1 = new UserDto();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userDto1 = userMapper.appRetrieveUserInfo(userDto);
            return userDto1;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appModifyUserInfo(UserDto userDto){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.appModifyUserInfo(userDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appModifyUserAlarm(UserDto userDto){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.appModifyUserAlarm(userDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public UserDto appRetrieveUserAlarm(UserDto userDto){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.appRetrieveUserAlarm(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<UserDto> getUserList(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public UserDto getUserInfo(UserDto userDto){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserInfo(userDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

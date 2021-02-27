package org.BG.DAO;

import org.BG.DTO.*;
import org.BG.Mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    SqlSession sqlSession;

    public void changeComNo(UserDto userDto){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.changeComNo(userDto);
    }

    public void addStoreCount(String title){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addStoreCount(title);
    }

    public void minusStoreCount(String title){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.minusStoreCount(title);
    }

    public void updateVersion(String version){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateVersion(version);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String appCheckVersion(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.appCheckVersion();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

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

    public String RetrieveUserFcm(int user_No){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.RetrieveUserFcm(user_No);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getUserFcm(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserFcm();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int getUserAreaCount(String area){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserAreaCount(area);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<UserDto> getBlackList(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getBlackList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<UserDto> getUnBlackList(){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUnBlackList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void modifyUserState(UserDto userDto){
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.modifyUserState(userDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteUserInfo(UserDto userDto){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserInfo(userDto);
    }

    public StoreCountDto getStoreCount(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getStoreCount();
    }

    //test
    public void updateUserPwd(UserDto userDto){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUserPwd(userDto);
    }
    public ArrayList<UserDto> getAllUser(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getAllUser();
    }
    public UserDto searchUser(int userNo){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.searchUser(userNo);
    }

}

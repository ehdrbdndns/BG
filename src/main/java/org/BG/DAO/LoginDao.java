package org.BG.DAO;

import org.BG.DTO.AdminDto;
import org.BG.DTO.RegisterDto;
import org.BG.DTO.UserDto;
import org.BG.Mapper.LoginMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Repository
public class LoginDao {
    @Autowired
    SqlSession sqlSession;

    @Scheduled(cron = "0 0 12 * * ?" )
    public void schedulerRegister(){
        try{
            System.out.println("register table clean");
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            loginMapper.appCleanRegister(getBeforeDay());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String appLogin(UserDto userDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            Integer user_No = loginMapper.appLogin(userDto);
            if(user_No == null || user_No == 0){
                return "false";
            } else{
                String date = getToday();
                Integer checkUserVisitor = loginMapper.isUserVisitor(date);
                if(checkUserVisitor == 0){
                    loginMapper.insertUserVisitor(date);
                } else{
                    loginMapper.updateUserVisitor(checkUserVisitor);
                }
                return Integer.toString(user_No);
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appSendCodeOfRegister(RegisterDto registerDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            return Integer.toString(loginMapper.appSendCode(registerDto));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appConfirmCodeOfRegister(RegisterDto registerDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            Integer result = loginMapper.appConfirmCodeOfRegister(registerDto);
            if(result == null || result == 0)
                return null;
            else
                return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public String appRegister(UserDto userDto){
        try{
         LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
         return Integer.toString(loginMapper.appRegister(userDto));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appRegisterOfComImg(UserDto userDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            loginMapper.appRegisterOfComImg(userDto);
            loginMapper.appRegisterOfStore(userDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appSearchEmail(UserDto userDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            String user_Email = loginMapper.appSearchEmail(userDto);
            if(user_Email.equals("") || user_Email == null){
                return "false";
            } else{
                return user_Email;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String appSendCodeOfSearch(RegisterDto registerDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            Integer user_No = loginMapper.appIsExistUserEmail(registerDto);
            if(user_No == null || user_No == 0){
                return "false";
            } else{
                return Integer.toString(loginMapper.appSendCode(registerDto));
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getBeforeDay(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    public String appChangePwd(UserDto userDto){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            loginMapper.appChangePwd(userDto);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public AdminDto adminLogin(){
        try{
            LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
            return loginMapper.adminLogin();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}

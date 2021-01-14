package org.BG.DAO;

import org.BG.DTO.PushDto;
import org.BG.Mapper.PushMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PushDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<PushDto> getPushInfo(){
        try{
            PushMapper pushMapper = sqlSession.getMapper(PushMapper.class);
            return pushMapper.getPushInfo();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public PushDto retrievePushInfo(PushDto pushDto){
        try{
            PushMapper pushMapper = sqlSession.getMapper(PushMapper.class);
            return pushMapper.retrievePushInfo(pushDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void registerPushInfo(PushDto pushDto){
        try{
            PushMapper pushMapper = sqlSession.getMapper(PushMapper.class);
            pushMapper.registerPushInfo(pushDto);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletePushInfo(PushDto pushDto){
        try{
            PushMapper pushMapper = sqlSession.getMapper(PushMapper.class);
            pushMapper.deletePushInfo(pushDto);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void modifyPushInfo(PushDto pushDto){
        try{
            PushMapper pushMapper = sqlSession.getMapper(PushMapper.class);
            pushMapper.modifyPushInfo(pushDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

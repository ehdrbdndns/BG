package org.BG.DAO;

import org.BG.DTO.NoticeDto;
import org.BG.Mapper.NoticeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class NoticeDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<NoticeDto> appGetAnnounce(){
        try{
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            return noticeMapper.appGetAnnounce();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<NoticeDto> getAnnounceList(){
        try{
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            return noticeMapper.getAnnounceList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveAnnounce(NoticeDto noticeDto){
        try{
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            noticeMapper.saveAnnounce(noticeDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public NoticeDto getAnnounceInfo(NoticeDto noticeDto){
        try{
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            return noticeMapper.getAnnounceInfo(noticeDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean modifyAnnounce(NoticeDto noticeDto){
        try{
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            noticeMapper.modifyAnnounce(noticeDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNotice(NoticeDto noticeDto){
        try{
            NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
            noticeMapper.deleteNotice(noticeDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

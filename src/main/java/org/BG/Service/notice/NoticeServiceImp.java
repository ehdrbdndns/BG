package org.BG.Service.notice;

import org.BG.DAO.NoticeDao;
import org.BG.DTO.NoticeDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class NoticeServiceImp implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Override
    public String appGetAnnounce() {
        JSONArray result = new JSONArray();
        try {
            ArrayList<NoticeDto> noticeDtos = noticeDao.appGetAnnounce();
            for (int i = 0; i < noticeDtos.size(); i++) {
                JSONObject notice = new JSONObject();
                notice.put("title", noticeDtos.get(i).getAn_Title());
                notice.put("content", noticeDtos.get(i).getAn_Contents());
                notice.put("regDate", noticeDtos.get(i).getAn_RegDate());
                result.add(notice);
            }
            return result.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<NoticeDto> getAnnounceList() {
        try{
            return noticeDao.getAnnounceList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveAnnounce(NoticeDto noticeDto) {
        try{
            noticeDto.setAn_RegDate(getToday());
            return noticeDao.saveAnnounce(noticeDto);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public NoticeDto getAnnounceInfo(NoticeDto noticeDto) {
        try{
            return noticeDao.getAnnounceInfo(noticeDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean modifyAnnounce(NoticeDto noticeDto) {
        try{
            noticeDto.setAn_RegDate(getToday());
            return noticeDao.modifyAnnounce(noticeDto);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteNotice(NoticeDto noticeDto) {
        try{
            return noticeDao.deleteNotice(noticeDto);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}

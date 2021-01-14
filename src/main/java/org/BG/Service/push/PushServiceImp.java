package org.BG.Service.push;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.TopicManagementResponse;
import org.BG.DAO.PushDao;
import org.BG.DAO.UserDao;
import org.BG.DTO.PushDto;
import org.BG.Mapper.PushMapper;
import org.BG.util.firebase.FirebaseMessagingSnippets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PushServiceImp implements PushService {
    @Autowired
    PushDao pushDao;
    @Autowired
    UserDao userDao;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;

    @Override
    public ArrayList<PushDto> getPushInfo() {
        try {
            return pushDao.getPushInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PushDto retrievePushInfo(PushDto pushDto) {
        try {
            return pushDao.retrievePushInfo(pushDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void registerPushInfo(PushDto pushDto) {
        try {
            pushDto.setAp_RegDate(getToday());
            pushDao.registerPushInfo(pushDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePushInfo(PushDto pushDto) {
        try {
            pushDao.deletePushInfo(pushDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyPushInfo(PushDto pushDto){
        try{
            pushDao.modifyPushInfo(pushDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean sendPushContentToUser(HttpServletRequest request, PushDto pushDto) {
        try{
            List<String> tokenId = userDao.getUserFcm();
            firebaseMessagingSnippets.test_sendAll_FCM(tokenId, pushDto.getAp_Title(), request);
            return true;
        }catch (Exception e){
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

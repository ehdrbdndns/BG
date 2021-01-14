package org.BG.Service.push;

import org.BG.DTO.PushDto;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface PushService {
    ArrayList<PushDto> getPushInfo();
    PushDto retrievePushInfo(PushDto pushDto);
    void registerPushInfo(PushDto pushDto);
    void deletePushInfo(PushDto pushDto);
    void modifyPushInfo(PushDto pushDto);
    boolean sendPushContentToUser(HttpServletRequest request, PushDto pushDto);
}

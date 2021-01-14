package org.BG.Mapper;

import org.BG.DTO.PushDto;

import java.util.ArrayList;

public interface PushMapper {
    ArrayList<PushDto> getPushInfo();
    PushDto retrievePushInfo(PushDto pushDto);
    void registerPushInfo(PushDto pushDto);
    void deletePushInfo(PushDto pushDto);
    void modifyPushInfo(PushDto pushDto);
}

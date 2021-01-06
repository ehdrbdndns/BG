package org.BG.Service.notice;

import org.BG.DTO.NoticeDto;

import java.util.ArrayList;

public interface NoticeService {
    String appGetAnnounce();
    ArrayList<NoticeDto> getAnnounceList();
    boolean saveAnnounce(NoticeDto noticeDto);
    NoticeDto getAnnounceInfo(NoticeDto noticeDto);
    boolean modifyAnnounce(NoticeDto noticeDto);
    boolean deleteNotice(NoticeDto noticeDto);
}

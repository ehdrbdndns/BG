package org.BG.Mapper;

import org.BG.DTO.NoticeDto;

import java.util.ArrayList;

public interface NoticeMapper {
    ArrayList<NoticeDto> appGetAnnounce();
    ArrayList<NoticeDto> getAnnounceList();
    void saveAnnounce(NoticeDto noticeDto);
    NoticeDto getAnnounceInfo(NoticeDto noticeDto);
    void modifyAnnounce(NoticeDto noticeDto);
    void deleteNotice(NoticeDto noticeDto);
}

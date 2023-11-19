package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.dto.mr.statistics.*;
import com.kosa.resq.domain.vo.mr.TemplateVO;

import java.util.List;

public interface MrAdminService {
    public List<MrDTO> mrGetAll();
    public MrDTO mrGetOne(String mr_code);
    public List<MrRezDTO> mrRezGetAll();
    public List<MrRezDTO> mrRezRankGetAll();
    public List<NoticeDTO> noticeGetAll();
    public void noticeSave(NoticeDTO notice);
    public void mrSave(MrDTO mr);
    public void mrAvailableDaySave(MrOpDayDTO mrOpDay);
    public void mrKeywordSave(MrKeyWordDTO mrKeyWord);
    public void mrUpdate(MrDTO mr);
    public void mrDeactivate(MrDTO mr);
    public List<TemplateVO> templateGetAll();
    public NoticeDTO noticeGetOne(String notice_code);
    public void noticeDelete(String notice_code);
    public void mrImgSave(MrImgDTO img);
    public void mrOpDayUpdate(MrOpDayDTO day);
    public void mrImgDelete(String img_code);
    public List<MrRezTimeDTO> mrRezTimeGetAll();
    public MrRezRowDTO mrRezRowGetAll();
    public List<MrRezTypeDTO> mrRezTypeGetAll();
    public List<MrRezDateDTO>mrRezDateGetAll();
    public List<MrRezFavTimeDTO>mrRezFavTimeGetAll();
    public void mrCheckIn(String mr_code);
    public void mrCheckOut(String mr_code);
    public MrRezForQRDTO mrRezGetOne(String mr_rez_code);
    public List<MrRezParticipantDTO> mrRezPtGetAll(String mr_rez_code);
    public void noticeUpdate(NoticeDTO notice);
}

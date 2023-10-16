package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.*;

import java.util.List;

public interface MrAdminService {
    public List<MrDTO> mrList();
    public List<MrRezDTO> mrRez();
    public List<NoticeDTO> noticeList();
    public void addNotice(NoticeDTO notice);
    public void addMr(MrDTO mr);
    public void mrAvailableDay(MrOpDayDTO mrOpDay);
    public void addMrKeyword(MrKeyWordDTO mrKeyWord);
}

package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.mr.TemplateVO;

import java.util.List;

public interface MrAdminService {
    public List<MrDTO> mrGetAll();
    public List<MrRezDTO> mrRezGetAll();
    public List<NoticeDTO> noticeGetAll();
    public void noticeSave(NoticeDTO notice);
    public void mrSave(MrDTO mr);
    public void mrAvailableDaySave(MrOpDayDTO mrOpDay);
    public void mrKeywordSave(MrKeyWordDTO mrKeyWord);
    public void mrUpdate(MrDTO mr);
    public void mrDeactivate(MrDTO mr);
    public List<TemplateVO> templateGetAll();
}

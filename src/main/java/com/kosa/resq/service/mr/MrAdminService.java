package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;
import com.kosa.resq.domain.dto.mr.NoticeDTO;

import java.util.List;

public interface MrAdminService {
    public List<MrDTO> mrList();
    public List<MrRezDTO> mrRez();
    public List<NoticeDTO> noticeList();
    public void addNotice(NoticeDTO notice);
}

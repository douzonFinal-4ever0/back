package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;
import com.kosa.resq.domain.dto.mr.NoticeDTO;
import com.kosa.resq.mapper.mr.MrAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MrAdminServiceImpl implements MrAdminService {
    @Autowired
    private MrAdminMapper mapper;
    @Override
    public List<MrDTO> mrList() {
        return mapper.mrList();
    }
    public List<MrRezDTO> mrRez() {
        return mapper.mrRez();
    }

    @Override
    public List<NoticeDTO> noticeList() {
        return mapper.noticeList();
    }

    @Override
    public void addNotice(NoticeDTO notice) {
        mapper.addNotice(notice);
    }

}

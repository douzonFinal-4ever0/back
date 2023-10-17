package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.*;
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
    @Override
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

    @Override
    public void addMr(MrDTO mr) {
        mapper.addMr(mr);
    }

    @Override
    public void mrAvailableDay(MrOpDayDTO mrOpDay) {
        mapper.mrAvailableDay(mrOpDay);
    }

    @Override
    public void addMrKeyword(MrKeyWordDTO mrKeyWord) {
        mapper.addMrKeyword(mrKeyWord);
    }

}

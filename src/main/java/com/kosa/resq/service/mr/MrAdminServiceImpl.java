package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.mr.TemplateVO;
import com.kosa.resq.mapper.mr.MrAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MrAdminServiceImpl implements MrAdminService {
    @Autowired
    private MrAdminMapper mapper;
    @Override
    public List<MrDTO> mrGetAll() {
        return mapper.mrGetAll();
    }
    @Override
    public List<MrRezDTO> mrRezGetAll() {
        return mapper.mrRezGetAll();
    }

    @Override
    public List<NoticeDTO> noticeGetAll() {
        return mapper.noticeGetAll();
    }

    @Override
    public void noticeSave(NoticeDTO notice) {
        mapper.noticeSave(notice);
    }

    @Override
    public void mrSave(MrDTO mr) {
        mapper.mrSave(mr);
    }

    @Override
    public void mrAvailableDaySave(MrOpDayDTO mrOpDay) {
        mapper.mrAvailableDaySave(mrOpDay);
    }

    @Override
    public void mrKeywordSave(MrKeyWordDTO mrKeyWord) {
        mapper.mrKeywordSave(mrKeyWord);
    }

    @Override
    public void mrUpdate(MrDTO mr) {
        mapper.mrUpdate(mr);
    }

    @Override
    public void mrDeactivate(MrDTO mr) {
        mapper.mrDeactivate(mr);
    }

    @Override
    public List<TemplateVO> templateGetAll() {
        return mapper.templateGetAll();
    }

    @Override
    public NoticeDTO noticeGetOne(String notice_code) {
        return mapper.noticeGetOne(notice_code);
    }

    @Override
    public void noticeDelete(String notice_code) {
        mapper.noticeDelete(notice_code);
    }

    @Override
    public void mrImgSave(MrImgDTO img) {
        mapper.mrImgSave(img);
    }

    @Override
    public void mrOpDayUpdate(MrOpDayDTO day) {
        mapper.mrOpDayUpdate(day);
    }

}

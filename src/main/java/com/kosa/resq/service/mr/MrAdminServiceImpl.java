package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.dto.mr.statistics.*;
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
    public MrDTO mrGetOne(String mr_code) {
        return mapper.mrGetOne(mr_code);
    }

    @Override
    public List<MrRezDTO> mrRezGetAll() {
        return mapper.mrRezGetAll();
    }

    @Override
    public List<MrRezDTO> mrRezRankGetAll() {
        return mapper.mrRezRankGetAll();
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

    @Override
    public void mrImgDelete(String img_code) {
        mapper.mrImgDelete(img_code);
    }

    @Override
    public List<MrRezTimeDTO> mrRezTimeGetAll() {
        return mapper.mrRezTimeGetAll();
    }

    @Override
    public MrRezRowDTO mrRezRowGetAll() {
        return mapper.mrRezRowGetAll();
    }

    @Override
    public List<MrRezTypeDTO> mrRezTypeGetAll() {
        return mapper.mrRezTypeGetAll();
    }

    @Override
    public List<MrRezDateDTO> mrRezDateGetAll() {
        return mapper.mrRezDateGetAll();
    }

    @Override
    public List<MrRezFavTimeDTO> mrRezFavTimeGetAll() {
        return mapper.mrRezFavTimeGetAll();
    }

    @Override
    public void mrCheckIn(String mr_code) {
        mapper.mrCheckIn(mr_code);
    }

    @Override
    public void mrCheckOut(String mr_code) {
        mapper.mrCheckOut(mr_code);
    }

    @Override
    public MrRezForQRDTO mrRezGetOne(String mr_rez_code) {
        return mapper.mrRezGetOne(mr_rez_code);
    }

    @Override
    public List<MrRezParticipantDTO> mrRezPtGetAll(String mr_rez_code) {
        return mapper.mrRezPtGetAll(mr_rez_code);
    }

    @Override
    public void noticeUpdate(NoticeDTO notice) {
        mapper.noticeUpdate(notice);
    }

}

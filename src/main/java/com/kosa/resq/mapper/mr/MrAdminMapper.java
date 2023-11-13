package com.kosa.resq.mapper.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.dto.mr.statistics.MrRezRowDTO;
import com.kosa.resq.domain.dto.mr.statistics.MrRezTimeDTO;
import com.kosa.resq.domain.dto.mr.statistics.MrRezTypeDTO;
import com.kosa.resq.domain.vo.mr.TemplateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MrAdminMapper {
    public List<MrDTO> mrGetAll();
    public MrDTO mrGetOne(String mr_code);
    public List<MrRezDTO> mrRezGetAll();
    public List<MrRezDTO> mrRezRank();
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
    public List<MrRezTimeDTO> mrRezTime();
    public MrRezRowDTO mrRezRow();
    public List<MrRezTypeDTO> mrRezType();
}

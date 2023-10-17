package com.kosa.resq.mapper.mr;

import com.kosa.resq.domain.dto.mr.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MrAdminMapper {
    public List<MrDTO> mrList();
    public List<MrRezDTO> mrRez();
    public List<NoticeDTO> noticeList();
    public void addNotice(NoticeDTO notice);
    public void addMr(MrDTO mr);
    public void mrAvailableDay(MrOpDayDTO mrOpDay);
    public void addMrKeyword(MrKeyWordDTO mrKeyWord);
}

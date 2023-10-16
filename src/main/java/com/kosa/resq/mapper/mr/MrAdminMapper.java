package com.kosa.resq.mapper.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;
import com.kosa.resq.domain.dto.mr.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MrAdminMapper {
    public List<MrDTO> mrList();
    public List<MrRezDTO> mrRez();
    public List<NoticeDTO> noticeList();
    public void addNotice(NoticeDTO notice);
}

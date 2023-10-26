package com.kosa.resq.mapper.mr;

import com.kosa.resq.domain.vo.mr.MrRequestVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.domain.vo.mr.MrRezRequestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MrUserMapper {
    public void mrRezSave(MrRezRequestVO mrRezRequestVO);
    public List<MrResponseVO> mrRecommendGetAll(@Param("rez_date") String rez_date , @Param("rez_start_time") String rez_start_time, @Param("rez_end_time") String rez_end_time);
}

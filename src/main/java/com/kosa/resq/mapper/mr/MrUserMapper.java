package com.kosa.resq.mapper.mr;

import com.kosa.resq.domain.dto.mr.BmGroupMemResponseDTO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MrUserMapper {
    public void mrRezSave(MrRezRequestVO mrRezRequestVO);

    public List<MemResponseVO> memGetAll();

    public MemResponseVO memGetOne(String mem_code);

    public List<MrResponseVO> mrRecommendGetAll(String rez_date, String rez_start_time, String rez_end_time, int tot_pt_ctn);

    public List<BmGroupMemResponseDTO> bmGroupMemGetAll(String mem_code);

    public void bmGroupSave(String bm_group_name, String mem_code);

    public String bmGroupGetOne(String mem_code);

    public void bmGroupMemSave(String bm_group_code, String mem_code);

    public List<BmMrVO> bmMrGetAll(String mem_code);

    public List<MrResponseVO> recentMrGetFive(String mem_code);
}

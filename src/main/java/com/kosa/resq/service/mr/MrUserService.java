package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.dto.mr.statistics.BmMrRequestDTO;
import com.kosa.resq.domain.dto.mr.statistics.MrRezFavTimeDTO;
import com.kosa.resq.domain.dto.mr.statistics.RezStatisticsDTO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.BmMrVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.domain.vo.mr.MrRezResponseVO;

import java.text.ParseException;
import java.util.List;

public interface MrUserService {
    public void mrRezSave(MrRezRequestDTO mrRezRequestDTO);

    public void mrRezUpdate(MrRezRequestDTO mrRezRequestDTO);

    public void mrRezDelete(String mr_rez_code);

    public List<MrRezResponseVO> mrRezGetAllByDate(String date);

    public List<MrRezResponseVO> mrRezGetAllByMem(String mem_code);

    public List<MrRezResponseVO> mrRezGetAllByPt (String mem_code);

    public List<MrRezResponseVO> recentMrRezGetAll(String mem_code);

    public List<MrResponseVO> mrRecommendGetAll(MrRecommendRequestDTO mrRecommendRequestDTO);

    public List<MemResponseVO> memGatAll();

    public List<BmGroupMemResponseDTO> bmGroupMemGetAll(String mem_code);

    public void bmGroupMemSave(BmGroupRequestDTO bmGroupRequestDTO);

    public List<BmMrVO> bmMrGetAll(String mem_code);

    public void bmMrSave(BmMrRequestDTO bmMrRequestDTO);

    public List<RezStatisticsDTO> mrRezCharTwo (String date);
}

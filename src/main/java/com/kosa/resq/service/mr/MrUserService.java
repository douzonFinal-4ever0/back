package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.BmMrVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.domain.vo.mr.MrRezResponseVO;

import java.util.List;

public interface MrUserService {
    public void mrRezSave(MrRezRequestDTO mrRezRequestDTO);

    public List<MrRezResponseVO> mrRezGetAllByMem(String mem_code);

    public List<MrRezResponseVO> mrRezGetAllByPt (String mem_code);

    public List<MrRezResponseVO> recentMrRezGetAll(String mem_code);

    public List<MrResponseVO> mrRecommendGetAll(MrRecommendRequestDTO mrRecommendRequestDTO);

    public List<MemResponseVO> memGatAll();

    public List<BmGroupMemResponseDTO> bmGroupMemGetAll(String mem_code);

    public void bmGroupMemSave(BmGroupRequestDTO bmGroupRequestDTO);

    public List<BmMrVO> bmMrGetAll(String mem_code);
}

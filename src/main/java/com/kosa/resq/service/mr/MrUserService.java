package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;

import java.util.List;

public interface MrUserService {
    public void mrRezSave(MrRezRequestDTO mrRezRequestDTO);

    public List<MrResponseVO> mrRecommendGetAll(MrRecommendRequestDTO mrRecommendRequestDTO);

    public List<MemResponseVO> memGatAll();

    public List<BmGroupMemResponseDTO> bmGroupMemGetAll(String mem_code);

    public void bmGroupMemSave(BmGroupRequestDTO bmGroupRequestDTO);
}

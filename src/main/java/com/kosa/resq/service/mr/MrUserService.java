package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrRecommendRequestDTO;
import com.kosa.resq.domain.dto.mr.MrRezRequestDTO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;

import java.util.List;

public interface MrUserService {
    public void mrRezSave(MrRezRequestDTO mrRezRequestDTO);

    public List<MrResponseVO> mrRecommendGetAll(MrRecommendRequestDTO mrRecommendRequestDTO);
}

package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;

import java.util.List;

public interface MrAdminService {
    public List<MrDTO> mrList();
    public List<MrDTO> test();
    public List<MrRezDTO> test2();
}

package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;
import com.kosa.resq.mapper.mr.MrAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MrAdminServiceImpl implements MrAdminService {
    @Autowired
    private MrAdminMapper mapper;
    @Override
    public List<MrDTO> mrList() {
        return mapper.mrList();
    }

    @Override
    public List<MrDTO> test() {
        return mapper.test();
    }

    @Override
    public List<MrRezDTO> test2() {
        return mapper.test2();
    }
}

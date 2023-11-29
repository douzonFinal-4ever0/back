package com.kosa.resq.service.sp;

import com.kosa.resq.domain.dto.mr.MrSuppliesDTO;
import com.kosa.resq.domain.dto.mr.SuppliesDTO;
import com.kosa.resq.mapper.sp.SpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpServiceImpl implements SpService{
    @Autowired
    private SpMapper mapper;
    @Override
    public List<SuppliesDTO> suppliesGetAll() {
        return mapper.suppliesGetAll();
    }

    @Override
    public void mrSuppliesSave(MrSuppliesDTO mrSupplies) {
        mapper.mrSuppliesSave(mrSupplies);
    }

    @Override
    public void mrSuppliesDelete(String mr_code) {
        mapper.mrSuppliesDelete(mr_code);
    }

    @Override
    public int checkIfMRCodeExists(String mr_code) {
        return mapper.checkIfMRCodeExists(mr_code);
    }
}

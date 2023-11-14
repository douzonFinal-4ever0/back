package com.kosa.resq.service.sp;

import com.kosa.resq.domain.dto.mr.MrSuppliesDTO;
import com.kosa.resq.domain.dto.mr.SuppliesDTO;

import java.util.List;

public interface SpService {
    public List<SuppliesDTO> suppliesGetAll();
    public void mrSuppliesSave(MrSuppliesDTO mrSupplies);
}

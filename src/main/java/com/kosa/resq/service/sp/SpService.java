package com.kosa.resq.service.sp;

import com.kosa.resq.domain.dto.mr.MrSuppliesDTO;
import com.kosa.resq.domain.dto.mr.SuppliesDTO;

import java.util.List;

public interface SpService {
    public List<SuppliesDTO> suppliesGetAll();
    public void mrSuppliesSave(MrSuppliesDTO mrSupplies);
    public void mrSuppliesDelete(String mr_code);
    public int checkIfMRCodeExists(String mr_code);
}

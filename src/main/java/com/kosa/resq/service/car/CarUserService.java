package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;

public interface CarUserService {
    public CarRezDTO carRezInfoSave(CarRezDTO carRezDTO, CarLocDTO receiptLocDTO,CarLocDTO returnLocDTO,CarLocDTO destLocDTO);
}

package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;

public interface CarUserService {
    public CarRezResponseVO carRezSave(CarRezRequestVO carRezRequestVO);

}

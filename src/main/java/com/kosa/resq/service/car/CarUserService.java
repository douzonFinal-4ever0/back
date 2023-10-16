package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.CarDTO;
import com.kosa.resq.domain.dto.car.CarDetailDTO;
import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import com.kosa.resq.domain.vo.car.CarVO;

import java.util.List;

public interface CarUserService {
    public CarRezDTO carRezInfoSave(CarRezDTO carRezDTO);

    public List<CarDetailDTO> carGetAll();

    public CarDetailDTO carGetOne(String car_code);
}
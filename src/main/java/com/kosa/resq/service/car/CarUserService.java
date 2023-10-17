package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.CarDetailDTO;
import com.kosa.resq.domain.dto.car.CarDetailDTO2;
import com.kosa.resq.domain.dto.car.CarRezDTO;

import java.util.List;

public interface CarUserService {
    public CarRezDTO carRezInfoSave(CarRezDTO carRezDTO);

    public List<CarDetailDTO2> carGetAll();

    public CarDetailDTO2 carGetOne(String car_code);
}
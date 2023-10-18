package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.*;

import java.util.List;

public interface CarUserService {
    public CarRezDTO2 carRezInfoSave(CarRezDTO carRezDTO);

    public List<CarDetailDTO2> carGetAll();

    public CarDetailDTO2 carGetOne(String car_code);
    public List<CarLocDTO> carLocInfoGetAll(String car_rez_code);
}
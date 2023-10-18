package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.*;
import com.kosa.resq.domain.vo.car.AvailableCarResponseVO;
import com.kosa.resq.domain.vo.car.CarRezInfoResponseVO;

import java.util.List;

public interface CarUserService {
    public CarRezDTO2 carRezInfoSave(CarRezDTO carRezDTO);

    public List<CarDetailDTO2> carGetAll();
public List<AvailableCarResponseVO> carGetAll2();
    public CarDetailDTO2 carGetOne(String car_code);
    public List<CarLocDTO> carLocInfoGetAll(String car_rez_code);
    public List<CarRezInfoResponseVO> carRezGetAll(String mem_code);
}
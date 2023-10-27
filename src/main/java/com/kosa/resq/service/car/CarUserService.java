package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.*;
import com.kosa.resq.domain.vo.car.AvailableCarResponseVO;
import com.kosa.resq.domain.vo.car.CarNameCodeResponseVO;
import com.kosa.resq.domain.vo.car.CarRezInfoResponseVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface CarUserService {
    public CarRezDTO2 carRezInfoSave(CarRezDTO carRezDTO);

    public List<CarDetailDTO2> carGetAll();
public List<AvailableCarResponseVO> carGetAll2();
    public CarDetailDTO2 carGetOne(String car_code);
    public List<CarLocDTO> carLocInfoGetAll(String car_rez_code);
    public List<CarRezInfoResponseVO> carRezGetAll(String mem_code);
    public List<CarRezInfoResponseVO> filterCarRezGetAll(String mem_code,String rez_status);
    public List<CarNameCodeResponseVO> searchCarGetAll();
    public CarRezResponseVO carRezDetailGetOne(String car_rez_code);
    public int carRezDelete(String car_rez_code);
    public CarRezDTO2 carRezInfoUpdate(CarRezDTO carRezDTO);
//    public CarRezDTO2 getCarRezDTO2(CarRezDTO carRezDTO);
    public OperationDTO operationInfoSave(OperationDTO operationDTO);
}
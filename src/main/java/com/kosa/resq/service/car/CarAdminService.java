package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.CarDetailRequestVO;
import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import com.kosa.resq.domain.vo.car.CarUserRequestVO;
import com.kosa.resq.domain.vo.common.MemResponseVO;

import java.util.List;

public interface CarAdminService {

    public void carSave(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO);
    public List<CarResponseVO> carGetAll();
    CarResponseVO carGetOne(String car_code);
    public List<MemDTO> memGetAll();
}

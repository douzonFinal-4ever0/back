package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.*;

import java.util.List;

public interface CarAdminService {

    public void carSave(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO);
    public List<CarListResponseVO> carGetAll();
    CarListResponseVO carListGetOne(String car_code);
    public List<MemDTO> memGetAll();
    public CarDetailResponseVO carGetOne(String car_code);
}

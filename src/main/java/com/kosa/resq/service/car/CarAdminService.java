package com.kosa.resq.service.car;

import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;

import java.util.List;

public interface CarAdminService {

    public void carSave(CarRequestVO carVO);
    public List<CarResponseVO> carGetAll();
}

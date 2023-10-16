package com.kosa.resq.service.car;

import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import com.kosa.resq.mapper.car.CarAdminMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class CarAdminServiceImpl implements CarAdminService{

    @Autowired
    private CarAdminMapper carAdminMapper;
    @Override
    public void carSave(CarRequestVO carVO) {
        log.info("carSave 서비스 탐");
        carAdminMapper.carSave(carVO);
    }

    @Override
    public List<CarResponseVO> carGetAll() {
        return carAdminMapper.carGetAll();
    }


}

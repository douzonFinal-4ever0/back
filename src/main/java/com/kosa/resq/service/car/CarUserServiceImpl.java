package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import com.kosa.resq.mapper.car.CarUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarUserServiceImpl implements CarUserService{
    @Autowired
    private CarUserMapper mapper;
    @Transactional
    @Override
    public CarRezResponseVO carRezSave(CarRezRequestVO carRezRequestVO) {//객체를 리턴하는 것 생각해보기
        String carRezCode="REZ"+mapper.carRezSeq();
        carRezRequestVO.setCar_rez_code(carRezCode);
        return null;
    }
}

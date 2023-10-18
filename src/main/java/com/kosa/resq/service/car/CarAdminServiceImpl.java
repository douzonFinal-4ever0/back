package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.CarDetailRequestVO;
import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import com.kosa.resq.domain.vo.car.CarUserRequestVO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.mapper.car.CarAdminMapper;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class CarAdminServiceImpl implements CarAdminService{

    @Autowired
    private CarAdminMapper carAdminMapper;

    @Transactional
    @Override
    public void carSave(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO) {
        log.info("carSave 서비스 탐");
        log.info(carUserRequestVO.toString());
        if(carUserRequestVO.getMem_code() != null) {
            // 차량 지정자가 존재
            carAdminMapper.carSave(carVO);
            carAdminMapper.carDetailSave(carDetailRequestVO);
            carAdminMapper.carUserSave(carUserRequestVO);
        } else {
            carAdminMapper.carSave(carVO);
            carAdminMapper.carDetailSave(carDetailRequestVO);
        }

    }
    @Override
    public CarResponseVO carGetOne(String car_code) {
        return carAdminMapper.carGetOne(car_code);
    }

    @Override
    public List<CarResponseVO> carGetAll() {
        return carAdminMapper.carGetAll();
    }


    @Override
    public List<MemDTO> memGetAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<MemResponseVO> carResponseVOs = carAdminMapper.memGetAll();
        List<MemDTO> memDTOList = carResponseVOs.stream().map(source -> modelMapper.map(source, MemDTO.class)).collect(Collectors.toList());
        return memDTOList;
    }


}

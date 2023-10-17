package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.mapper.car.CarAdminMapper;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<MemDTO> memGetAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<MemResponseVO> carResponseVOs = carAdminMapper.memGetAll();
        List<MemDTO> memDTOList = carResponseVOs.stream().map(source -> modelMapper.map(source, MemDTO.class)).collect(Collectors.toList());
        return memDTOList;
    }


}

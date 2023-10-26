package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.mapper.car.CarAdminMapper;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public CarListResponseVO carListGetOne(String car_code) {
        return carAdminMapper.carListGetOne(car_code);
    }

    @Override
    public List<CarListResponseVO> carGetAll() {
        return carAdminMapper.carGetAll();
    }


    @Override
    public List<MemResponseVO> memGetAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<MemResponseVO> carResponseVOs = carAdminMapper.memGetAll();
//        List<MemDTO> memDTOList = carResponseVOs.stream().map(source -> modelMapper.map(source, MemDTO.class)).collect(Collectors.toList());
        return carResponseVOs;
    }

    @Override
    public CarDetailResponseVO carGetOne(String car_code) {
        return carAdminMapper.carGetOne(car_code);
    }

    @Transactional
    @Override
    public void carModify(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO) {
        // mapper
        carAdminMapper.carModify(carVO);
        carAdminMapper.carDetailModify(carDetailRequestVO);
        if(carVO.getAuthority().equals("지정")) {
            int result = carAdminMapper.carUserModify(carUserRequestVO);
            if(result == 0) {
                carAdminMapper.carUserSave(carUserRequestVO);
            }
        } else {
            carAdminMapper.carUserDelete(carVO.getCar_code());
        }
        
    }

    @Override
    public CarMaintItemResponseVO carMaintItemGetAll() {
        CarMaintItemResponseVO carMaintItemResponseVO = new CarMaintItemResponseVO();
        carMaintItemResponseVO.setCarMaintItemList(carAdminMapper.getCarMaintItemList());
        carMaintItemResponseVO.setMaintComList(carAdminMapper.getMaintComList());
        return carMaintItemResponseVO;
    }

    @Override
    public String maintRecordSave(MaintRecordRequestVO maintRecordRequestVO) {
        carAdminMapper.maintRecordSave(maintRecordRequestVO);
        maintRecordRequestVO.setMaint_code("MAINT" + maintRecordRequestVO.getMaint_code());
        return maintRecordRequestVO.getMaint_code();
    }

    @Override
    public List<MaintRecordResponseVO> maintOneCarRecordGetAll(String car_code) {
        return carAdminMapper.maintOneCarRecordGetAll(car_code);
    }


}

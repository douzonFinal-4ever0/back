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
    public void carDelete(String car_code) {
        carAdminMapper.updateCarStatus(car_code, "삭제됨");
    }

    @Override
    public CarMaintItemResponseVO carMaintItemGetAll() {
        CarMaintItemResponseVO carMaintItemResponseVO = new CarMaintItemResponseVO();
        carMaintItemResponseVO.setCarMaintItemList(carAdminMapper.getCarMaintItemList());
        carMaintItemResponseVO.setMaintComList(carAdminMapper.getMaintComList());
        return carMaintItemResponseVO;
    }

    @Transactional
    @Override
    public MaintRecordResponseVO maintRecordSave(MaintRecordRequestVO maintRecordRequestVO) {
        carAdminMapper.maintRecordSave(maintRecordRequestVO);
        maintRecordRequestVO.setMaint_code("MAINT" + maintRecordRequestVO.getMaint_code());

        // 차량 상태 '정비중'으로 변경
        carAdminMapper.updateCarStatus(maintRecordRequestVO.getCar_code(), "정비중");

        log.info(maintRecordRequestVO.getMaint_code());
        return carAdminMapper.maintRecordGetOne(maintRecordRequestVO.getMaint_code());
    }

    @Override
    public List<MaintRecordResponseVO> maintOneCarRecordGetAll(String car_code) {
        return carAdminMapper.maintOneCarRecordGetAll(car_code);
    }

    @Override
    public void maintEndAtUpdate(MaintModifyRequestVO maintModifyRequestVO) {
        // 정비 종료일을 현재 날짜로 등록
        for(String maint_code : maintModifyRequestVO.getMaint_codes()) {
            carAdminMapper.maintEndAtUpdate(maint_code);
        }
//       선택한 정비를 모두 완료처리를 하고, 차량의 상태를 변경시켜야 하는데, 정비 완료처리가 되지 않은 차량은 차량 상태를 변경하면 안됨..
        // 차량에 정비 등록일이 모두 적용되었는지 확인.
        int isMaintEnd = carAdminMapper.maintEndCheck(maintModifyRequestVO.getCar_code());
        // null인걸 찾음. 결과가 0이면 모두 정비 완료 처리되었다는 뜻.
        if(isMaintEnd == 0) {
            carAdminMapper.updateCarStatus(maintModifyRequestVO.getCar_code(), "사용가능");
        }

    }

    @Override
    public void maintRecordDelete(MaintModifyRequestVO maintModifyRequestVO) {
        // 정비 삭제 처리
        for(String maint_code : maintModifyRequestVO.getMaint_codes()) {
            carAdminMapper.maintRecordDelete(maint_code);
        }

        int isMaintEnd = carAdminMapper.maintEndCheck(maintModifyRequestVO.getCar_code());
        // null인걸 찾음. 결과가 0이면 모두 정비 완료 처리되었다는 뜻.
        if(isMaintEnd == 0) {
            carAdminMapper.updateCarStatus(maintModifyRequestVO.getCar_code(), "사용가능");
        }

    }

    @Override
    public List<OperationResponseVO> operationGetAll() {
        return carAdminMapper.operationGetAll();
    }

    @Override
    public List<CurrentMaintResponseVO> currentMaintGet(String car_code) {
        List<CurrentMaintResponseVO> currentMaintResponseVOList = carAdminMapper.currentMaintGet(car_code);
        currentMaintResponseVOList.forEach((item) -> {
            item.setAccum_mileage(carAdminMapper.accumeMileageGet(car_code));
        });
//        log.info(currentMaintResponseVOList.toString());
        return currentMaintResponseVOList;
    }


}

package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.SearchCar;
import com.kosa.resq.domain.dto.car.SearchOperation;
import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;

import java.util.List;

public interface CarAdminService {

    public void carSave(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO);
    public List<CarListResponseVO> carGetAll(SearchCar searchCar);
    CarUserResponseVO carListGetOne(String mem_code);
    public List<MemResponseVO> memGetAll();
    public CarDetailResponseVO carGetOne(String car_code);
    // 차량 수정
    public void carModify(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO);
    // 차량 삭제
    void carDelete(String car_code);
    // 차량 정비 항목, 정비 회사 정보 가져오기
    CarMaintItemResponseVO carMaintItemGetAll();
    // 차량 정비 등록
    MaintRecordResponseVO maintRecordSave(MaintRecordRequestVO maintRecordRequestVO);

    List<MaintRecordResponseVO> maintOneCarRecordGetAll(String car_code);
    void maintEndAtUpdate(MaintModifyRequestVO maintModifyRequestVO);
    void maintRecordDelete(MaintModifyRequestVO maintModifyRequestVO);
    // 운행 내역 조회
    List<OperationResponseVO> operationGetAll(SearchOperation searchOperation);
    List<CurrentMaintResponseVO> currentMaintGet(String car_code);
    List<OperationResponseVO> operationGetOne(String car_code);
    List<CarVO> carListGetAll();

}

package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarDetailDTO;
import com.kosa.resq.domain.dto.car.SearchOperation;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarAdminMapper {
    // 차량 등록
    void carSave(CarRequestVO carRequestVO);
    void carDetailSave(CarDetailRequestVO carDetailRequestVO);
    void carUserSave(CarUserRequestVO carUserRequestVO);
    
    CarUserResponseVO carListGetOne(String mem_code);
    List<CarListResponseVO> carGetAll(SearchCarVO searchCarVO);
    List<MemResponseVO> memGetAll();
    CarDetailResponseVO carGetOne(String car_code);

    // 차량 수정
    int carModify(CarRequestVO carRequestVO);
    int carDetailModify(CarDetailRequestVO carDetailRequestVO);
    int carUserModify(CarUserRequestVO carUserRequestVO);

    int carUserDelete(String car_code);

    List<CarMaintResponseVO> getCarMaintItemList();
    List<MaintComResponseVO> getMaintComList();
    // 정비 등록
    void maintRecordSave(MaintRecordRequestVO maintRecordRequestVO);
    void updateCarStatus(String car_code, String status);

    // 정비 불러오기
    List<MaintRecordResponseVO> maintOneCarRecordGetAll(String car_code);

    MaintRecordResponseVO maintRecordGetOne(String maint_code);
    // 완료 처리
    void maintEndAtUpdate(String maint_code);

    int maintEndCheck(String car_code);

    void maintRecordDelete(String maint_code);
    // 운행 내역 조회
    List<OperationResponseVO> operationGetAll(SearchOperationVO searchOperationVO);
    List<CurrentMaintResponseVO> currentMaintGet(String car_code);

    int accumeMileageGet(String car_code);

    List<OperationResponseVO> operationGetOne(String car_code, String sdate, String edate);

    List<CarVO> carListGetAll();

    List<CarRezInfoResponseVO> carRezListGetAll(String sdate, String edate);

    CarRezResponseVO carRezGetOne(String car_rez_code);
    List<CarLocVO> carLocInfoGetOne(String car_rez_code);
    void carRezCancel(String car_rez_code);
    List<String> isExistOperation();

    void maintImageSave(String maint_code, String url);

    int getTotalCarCount();
    int getOperationCarCount(String sdate, String edata);
    List<CarStatisticsVO> getMaxOperCar(String sdate, String edate);
}

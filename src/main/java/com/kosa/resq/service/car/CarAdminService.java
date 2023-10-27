package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;

import java.util.List;

public interface CarAdminService {

    public void carSave(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO);
    public List<CarListResponseVO> carGetAll();
    CarListResponseVO carListGetOne(String car_code);
    public List<MemResponseVO> memGetAll();
    public CarDetailResponseVO carGetOne(String car_code);
    // 차량 수정
    public void carModify(CarRequestVO carVO, CarDetailRequestVO carDetailRequestVO, CarUserRequestVO carUserRequestVO);

    // 차량 정비 항목, 정비 회사 정보 가져오기
    CarMaintItemResponseVO carMaintItemGetAll();
    // 차량 정비 등록
    MaintRecordResponseVO maintRecordSave(MaintRecordRequestVO maintRecordRequestVO);

    List<MaintRecordResponseVO> maintOneCarRecordGetAll(String car_code);
    void maintEndAtUpdate(MaintModifyRequestVO maintModifyRequestVO);

}

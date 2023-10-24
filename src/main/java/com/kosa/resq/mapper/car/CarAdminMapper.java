package com.kosa.resq.mapper.car;

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
    
    CarListResponseVO carListGetOne(String car_code);
    List<CarListResponseVO> carGetAll();
    List<MemResponseVO> memGetAll();
    CarDetailResponseVO carGetOne(String car_code);

    // 차량 수정
    int carModify(CarRequestVO carRequestVO);
    int carDetailModify(CarDetailRequestVO carDetailRequestVO);
    int carUserModify(CarUserRequestVO carUserRequestVO);

    int carUserDelete(String car_code);

}

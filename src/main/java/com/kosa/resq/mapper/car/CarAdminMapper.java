package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarAdminMapper {
    public void carSave(CarRequestVO carRequestVO);
    void carDetailSave(CarDetailRequestVO carDetailRequestVO);
    void carUserSave(CarUserRequestVO carUserRequestVO);
    CarListResponseVO carListGetOne(String car_code);
    public List<CarListResponseVO> carGetAll();
    public List<MemResponseVO> memGetAll();
    public CarDetailResponseVO carGetOne(String car_code);

}

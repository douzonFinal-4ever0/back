package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.vo.car.CarDetailRequestVO;
import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import com.kosa.resq.domain.vo.car.CarUserRequestVO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CarAdminMapper {
    public void carSave(CarRequestVO carRequestVO);
    void carDetailSave(CarDetailRequestVO carDetailRequestVO);
    void carUserSave(CarUserRequestVO carUserRequestVO);
    CarResponseVO carGetOne(String car_code);
    public List<CarResponseVO> carGetAll();
    public List<MemResponseVO> memGetAll();

}

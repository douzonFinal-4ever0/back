package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CarAdminMapper {
    public void carSave(CarRequestVO carRequestVO);
    public List<CarResponseVO> carGetAll();

}

package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.car.CarRezVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarUserMapper {
    public CarRezVO CarRezSave(CarRezVO carRezVO);
}

package com.kosa.resq.mapper.car;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarUserMapper {
    public CarRezVO CarRezSave(CarRezVO carRezVO);
    public int carRezSeq();
}

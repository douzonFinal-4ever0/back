package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarUserMapper {
    //예약정보 저장
    public int carRezSave(CarRezRequestVO carRezRequestVO);
    public int carRezSeq();
}

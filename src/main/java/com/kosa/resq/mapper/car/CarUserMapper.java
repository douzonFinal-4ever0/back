package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarUserMapper {
    //예약정보 저장
    public int carRezSave(CarRezDTO carRezDTO);
    public int carRezSeq();
    public int carLocSave(CarLocDTO carLocDTO);
    public int carLocSeq();
}

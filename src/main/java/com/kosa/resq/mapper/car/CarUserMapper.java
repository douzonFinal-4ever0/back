package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarLocRequestVO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import com.kosa.resq.domain.vo.car.CarVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarUserMapper {
    //예약정보 저장
    public int carRezSave(CarRezRequestVO carRezRequestVO);
    public int carRezSeq();
    public int carLocSave(CarLocRequestVO CarLocRequestVO);
    public int carLocSeq();
    public List<CarVO> carGetAll();
}

package com.kosa.resq.controller.car;

import com.kosa.resq.domain.dto.car.CarDTO;
import com.kosa.resq.domain.vo.car.CarRequestVO;
import com.kosa.resq.domain.vo.car.CarResponseVO;
import com.kosa.resq.service.car.CarAdminService;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/admin")
public class CarAdminController {

    @Autowired
    private CarAdminService carAdminService;

    // 차량 등록
    @PostMapping("/car/carRegister")
    public void carSave(@RequestBody CarDTO carDTO) {
        log.info(carDTO.toString());
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CarRequestVO carRequestVO = mapper.map(carDTO, CarRequestVO.class);

        log.info(carRequestVO.toString());
        carAdminService.carSave(carRequestVO);
    }

    // 차량 조회 - 리스트
    @GetMapping("/car/carList")
    public List<CarResponseVO> carGetAll() {
        return carAdminService.carGetAll();
    }


    // 차량 조회 - 개별


    // 차량 수정

    // 차량 삭제



}

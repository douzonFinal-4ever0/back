package com.kosa.resq.controller.car;

import com.kosa.resq.domain.dto.car.CarDTO;
import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
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
        carDTO.getCarDetail().setCar_code(carDTO.getCar_code());
        carDTO.getCarDetail().setCar_status("사용가능");

//        log.info(carDTO.toString());
//        log.info(carDTO.getCarDetail().toString());
//        log.info(carDTO.getCarUser().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CarRequestVO carRequestVO = mapper.map(carDTO, CarRequestVO.class);

        CarDetailRequestVO carDetailRequestVO = mapper.map(carDTO.getCarDetail(), CarDetailRequestVO.class);
        CarUserRequestVO carUserRequestVO = mapper.map(carDTO.getCarUser(), CarUserRequestVO.class);

//        log.info(carRequestVO.toString());
//        log.info(carDetailRequestVO.toString());
//        log.info(carUserRequestVO.toString());

        carAdminService.carSave(carRequestVO, carDetailRequestVO, carUserRequestVO);
    }

    // 차량 조회 - 개별
    @GetMapping("/car/carListGetOne")
    public CarListResponseVO carListGetOne(@RequestParam String car_code) {
        log.info(car_code);
        return carAdminService.carListGetOne(car_code);
    }

    // 사용자 리스트 조회
    @GetMapping("/memList")
    public List<MemResponseVO> memGetAll() {
        return carAdminService.memGetAll();
    }

    // 차량 조회 - 리스트
    @GetMapping("/car/carList")
    public List<CarListResponseVO> carGetAll() {
        return carAdminService.carGetAll();
    }


    // 차량 상세 조회
    @GetMapping("/car/carGetOne")
    public CarDetailResponseVO carGetOne(@RequestParam String car_code) {
        return carAdminService.carGetOne(car_code);
    }

    // 차량 수정

    // 차량 삭제



}

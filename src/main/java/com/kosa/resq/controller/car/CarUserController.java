package com.kosa.resq.controller.car;

import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import com.kosa.resq.service.car.CarUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car_rez/*")
public class CarUserController {

    @Autowired
    private CarUserService service;

    @PostMapping("/rezSave")
    public ResponseEntity<CarRezResponseVO> carRezInfoSave(@RequestBody CarRezRequestVO carRezRequestVO){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CarRezDTO carRezDTO = mapper.map(carRezRequestVO,CarRezDTO.class);

        CarLocDTO receiptLocDTO = new CarLocDTO();
        receiptLocDTO.setCarRezDTO(carRezDTO);
        receiptLocDTO.setAddress(carRezRequestVO.getReceipt_loc());
        receiptLocDTO.setLoc_type("인수지");

        CarLocDTO returnLocDTO = new CarLocDTO();
        returnLocDTO.setCarRezDTO(carRezDTO);
        returnLocDTO.setAddress(carRezRequestVO.getReturn_loc());
        returnLocDTO.setLoc_type("반납지");

        CarLocDTO destLocDTO = new CarLocDTO();
        destLocDTO.setCarRezDTO(carRezDTO);
        destLocDTO.setAddress(carRezRequestVO.getDest_loc());
        destLocDTO.setLoc_type("목적지");

        service.carRezInfoSave(carRezDTO,receiptLocDTO,returnLocDTO,destLocDTO);
        return null;
    }

}

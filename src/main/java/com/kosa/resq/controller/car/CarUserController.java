package com.kosa.resq.controller.car;

import com.kosa.resq.domain.dto.car.CarDTO;
import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import com.kosa.resq.service.car.CarUserService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car_rez/*")
public class CarUserController {

    @Autowired
    private CarUserService service;

    @PostMapping("/rezSave")
    public ResponseEntity<CarRezDTO> carRezInfoSave(@RequestBody CarRezDTO carRezDTO){
        CarRezDTO result=service.carRezInfoSave(carRezDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/availableCars")
    public List<CarDTO> availableCarGetAll(){
        return service.carGetAll();
    }
}

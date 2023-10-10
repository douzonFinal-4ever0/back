package com.kosa.resq.controller.car;

import com.kosa.resq.service.car.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car_rez/*")
public class CarUserController {

    @Autowired
    private CarUserService service;

//    @GetMapping("/rezRegister")
//    public ResponseEntity<String> carRezSave(){
//
//    }

}

package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.AvailableCarResponseVO;
import com.kosa.resq.mapper.mr.MrUserMapper;
import com.kosa.resq.service.car.CarUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yaml")
class CarUserMapperTest {

    @Autowired
    private CarUserMapper mapper;
    @Test
    void carRezSave() {
        System.out.println(mapper.carGetAll3());
        List<AvailableCarResponseVO> cars = mapper.carGetAll3();
        for ( AvailableCarResponseVO car : cars){
            System.out.println(car);
        }
    }
}
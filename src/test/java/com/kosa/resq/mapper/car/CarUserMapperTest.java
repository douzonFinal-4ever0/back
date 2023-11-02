package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.service.car.CarUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yaml")
class CarUserMapperTest {

    @Autowired
    private CarUserMapper mapper;
    @Autowired
    private CarUserService service;
    @Test
    void carRezSave() {
//        System.out.println(mapper.carRezGetAll("MEM001"));
//        System.out.println(mapper.filterCarRezGetAll("MEM001","0"));
//        System.out.println(mapper.searchCarGetAll());
        String dateString = "Sat Nov 04 2023 09:00:00 GMT+0900";
        String dateString2 = "Sat Nov 05 2023 09:00:00 GMT+0900";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", java.util.Locale.ENGLISH);

        try {
            Date date = dateFormat.parse(dateString);
            Date date2 = dateFormat.parse(dateString2);
            System.out.println(date);
            System.out.println(mapper.carGetAll2(date,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
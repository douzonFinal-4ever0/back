package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarRezDTO;
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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yaml")
class CarUserMapperTest {

    @Autowired
    private CarUserMapper mapper;
    @Autowired
    private CarUserService service;
    @Autowired
    private MrUserMapper mapper2;
    @Test
    void carRezSave() {
//        System.out.println(mapper.carRezGetAll("MEM001"));
//        System.out.println(mapper.filterCarRezGetAll("MEM001","0"));
//        System.out.println(mapper.searchCarGetAll());
//        String dateString = "2023-11-03 09:00:00";
//        String dateString2 = "2023-11-03 15:00:00";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date date = dateFormat.parse(dateString);
//            Date date2 = dateFormat.parse(dateString2);
//            System.out.println(date);
//            System.out.println(mapper.carGetAll2(date,date2,"MEM001"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(mapper.filterCarRezGetAll("MEM001","1",0));
//        String[] array={"MEM001"};
//        System.out.println(mapper.memAlarmGetAll(array));
    }
}
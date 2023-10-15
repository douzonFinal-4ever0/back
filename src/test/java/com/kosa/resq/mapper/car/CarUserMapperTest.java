package com.kosa.resq.mapper.car;

import com.kosa.resq.domain.dto.car.CarRezDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application.yaml")
class CarUserMapperTest {

    @Autowired
    private CarUserMapper mapper;
    @Test
    void carRezSave() {
        System.out.println(mapper.carGetAll());
    }
}
package com.kosa.resq.mapper.mr;

import com.kosa.resq.mapper.car.CarAdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yaml")
class MrAdminMapperTest {
    @Autowired
    private CarAdminMapper mapper;

    @Test
    public void test(){
        System.out.println(mapper.test());
    }
}
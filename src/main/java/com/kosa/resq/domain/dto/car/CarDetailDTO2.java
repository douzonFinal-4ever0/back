package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.vo.car.CarVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDetailDTO2 {
    private CarVO carVO;
    private float fuel_effciency;
    private float accum_mileage;
    private String car_status;
    private Date updated_at;
    private double car_latitude;
    private double car_longitude;
    private String car_address;
}
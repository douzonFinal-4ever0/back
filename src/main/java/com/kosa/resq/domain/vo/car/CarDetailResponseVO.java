package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDetailResponseVO {
    private CarVO carVO;
    private double fuel_effciency;
    private double accum_mileage;
    private String car_status;
    private Date updated_at;
    private double car_latitude;
    private double car_longitude;
    private String car_address;
    private CarUserResponseVO carUser;
}

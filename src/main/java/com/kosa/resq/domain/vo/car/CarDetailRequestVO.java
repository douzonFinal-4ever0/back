package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailRequestVO {
    private String car_code;
    private double fuel_effciency;
    private double accum_mileage;
    private String car_status;
    private Date updated_at;
    private double car_latitude;
    private double car_longitude;
    private String car_address;

    public CarDetailRequestVO(String car_code, double accum_mileage, double car_latitude, double car_longitude, String car_address) {
        this.car_code = car_code;
        this.accum_mileage = accum_mileage;
        this.car_latitude = car_latitude;
        this.car_longitude = car_longitude;
        this.car_address = car_address;
    }
}

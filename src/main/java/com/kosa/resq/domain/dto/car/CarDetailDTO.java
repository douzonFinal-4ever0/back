package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailDTO {
    private String car_code;
    private double fuel_effciency;
    private int accum_mileage;
    private String car_status;
    private Date updated_at;
    private int car_latitude;
    private int car_longitude;
    private String car_address;
}

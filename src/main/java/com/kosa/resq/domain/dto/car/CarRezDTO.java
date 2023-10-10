package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRezDTO {
    private String mem_code;
    //    private String name;
//    private String dept_name;
//    private String position_name;
    private String detail;
    private Date start_at;//대여일자
    private int rental_time;
    private String end_loc;
    private float est_mileage;
    private String rez_status;
    //private String car_name;
    private String car_code;
//    private float accum_mileage;
//    private String authority;
//    private String fuel_type;
//    private float fuel_effciency;
}

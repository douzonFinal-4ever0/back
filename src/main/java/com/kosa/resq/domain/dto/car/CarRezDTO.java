package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CarRezDTO {
    private String mem_code;
    private String name;
    private String dept_name;
    private String position_name;
    private String detail;
    private Date start_at;
    private int rental_time;
    private String start_loc;
    private String end_loc;
    private float est_mileage;
    private String rez_status;
    private String car_name;
    private String car_code;
    private float accum_mileage;
    private String authority;
    private String fuel_type;
    private float fuel_effciency;

    public CarRezDTO(String mem_code, String name, String dept_name, String position_name, String detail,
                     int rental_time, String start_loc, String end_loc, float est_mileage, String car_name, String car_code,
                     float accum_mileage, String authority, String fuel_type, float fuel_effciency) {
        this.mem_code = mem_code;
        this.name = name;
        this.dept_name = dept_name;
        this.position_name = position_name;
        this.detail = detail;
        this.rental_time = rental_time;
        if(start_loc==""){
            this.start_loc = "";
        }else{
            this.start_loc=start_loc;
        }
        this.end_loc = end_loc;
        this.est_mileage = est_mileage;
        this.car_name = car_name;
        this.car_code = car_code;
        this.accum_mileage = accum_mileage;
        this.authority = authority;
        this.fuel_type = fuel_type;
        this.fuel_effciency = fuel_effciency;
        this.rez_status="확정";

    }
}

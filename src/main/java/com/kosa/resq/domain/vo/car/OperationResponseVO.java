package com.kosa.resq.domain.vo.car;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationResponseVO {

    private String operation_code;
    private String memo;
    private double bef_mileage;
    private double aft_mileage;
    private double distance;
    private Date created_at;
    private Date updated_at;
    private double nomal_biz_mileage;
    private double commute_mileage;

    private String detail;
    private Date start_at;
    private Date return_at;

    private String mem_code;
    private String name;
    private String position_name;
    private String dept_code;
    private String dept_name;

    private String car_code;
    private String car_name;
    private String type;
    private int accum_mileage;
    private String car_status;

    private String car_rez_code;

    private List<CarLocVO> carLocList;

//    private double car_latitude;
//    private double car_longitude;
//    private String car_address;



}

package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OperationRequestVO {
    private String operation_code;
    private String memo;
    private double bef_mileage;
    private double aft_mileage;
    private double distance;
    private Date created_at;
    private Date updated_at;
    private double nomal_biz_mileage;
    private double commute_mileage;
    private String car_rez_code;
    private String mem_code;
    private String car_code;
}

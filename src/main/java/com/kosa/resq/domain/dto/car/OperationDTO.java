package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDTO {
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

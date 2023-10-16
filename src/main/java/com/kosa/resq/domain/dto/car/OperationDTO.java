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
    private int bef_mileage;
    private int aft_mileage;
    private int distance;
    private Date created_at;
    private Date updated_at;
    private int nomal_biz_mileage;
    private int commute_mileage;
    private String car_rez_code;
    private String mem_code;
    private String car_code;
}

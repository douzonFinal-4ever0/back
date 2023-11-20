package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarListResponseVO {
    private String type;
    private String car_name;
    private String car_code;
    private Date created_at;
    private int accum_mileage;
    private String memo;
    private String car_status;
    private String authority;
    private String max_capacity;
    private String mem_code;
    private String position_name;
    private String name;
    private String dept_name;
    private int overMaintCount;

}

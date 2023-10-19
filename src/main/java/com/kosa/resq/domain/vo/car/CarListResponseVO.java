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

}

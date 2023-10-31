package com.kosa.resq.domain.vo.car;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentMaintResponseVO {
    private String maint_item_code;
    private String maint_name;
    private int cycle;
    private int type;
    private String car_code;
    private int mileage;
    private Date maint_start_at;
    private int accum_mileage;
}

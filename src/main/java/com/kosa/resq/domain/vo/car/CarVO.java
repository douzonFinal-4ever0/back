package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarVO {
    private String car_code;
    private String car_name;
    private String type;
    private String fuel_type;
    private String authority;
    private Date buy_at;
    private String memo;
    private int max_capacity;
    private Date created_at;
}
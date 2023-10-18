package com.kosa.resq.domain.vo.car;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRequestVO {
    private String car_code;
    private String car_name;
    private String type;
    private String fuel_type;
    private String authority;
    private Date buy_at;
    private String memo;
}

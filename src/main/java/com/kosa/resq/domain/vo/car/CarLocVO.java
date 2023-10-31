package com.kosa.resq.domain.vo.car;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarLocVO {
    private String car_rez_code;
    private String loc_code;
    private String loc_type;
    private double latitude;
    private double longitude;
    private String address;
    private String mem_code;
    private String car_code;
}

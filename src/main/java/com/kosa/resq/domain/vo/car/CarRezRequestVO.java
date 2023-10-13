package com.kosa.resq.domain.vo.car;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRezRequestVO {
    private String car_rez_code;
    private Date rez_at;
    private String detail;
    private float est_mileage;
    private String rez_status;
    private Date start_at;
    private Date return_at;
    private Date updated_at;
    private String mem_code;
    private String car_code;

}

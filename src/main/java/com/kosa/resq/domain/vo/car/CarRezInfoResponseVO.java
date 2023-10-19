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
public class CarRezInfoResponseVO {
    private String car_rez_code;
    private String rez_status;
    private Date start_at;
    private Date return_at;
    private String name;
    private String dept_name;
    private String car_name;
    private String car_code;
    private String detail;
    private String type;
}

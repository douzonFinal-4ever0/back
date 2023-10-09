package com.kosa.resq.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarInsuranceVO {
    private String ic_code;
    private String car_code;
    private String manager;
    private String manager_tel;
    private Date join_at;
    private Date expir_at;
}

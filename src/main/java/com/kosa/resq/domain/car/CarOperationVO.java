package com.kosa.resq.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarOperationVO {
    private String operation_code;
    private String memo;
    private float bef_mileage;
    private float aft_mileage;
    private float distance;
    private int classification;
    private CarRezVO carRezVO;
}

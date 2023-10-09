package com.kosa.resq.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccidentVO {
    private String accident_code;
    private int is_insurance;
    private String content;
    private int cost;
    private Date acci_at;
    private String post_processing;
    private String etc;
    private int premium;
    private int deductible;
    private Date start_at;
    private Date end_at;
    private CarOperationVO carOperationVO;
}

package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchOperationVO {
    private String operation_sdate;
    private String operation_edate;
    private String car_type;
    private String dept_name;
    private int sdistance;
    private int edistance;
}

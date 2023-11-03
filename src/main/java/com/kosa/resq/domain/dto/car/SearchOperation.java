package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchOperation {
    private Date operation_sdate;
    private Date operation_edate;
    private String car_type;
    private String dept_name;
    private int sdistance;
    private int edistance;
}

package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCar {
    private Date operation_sdate;
    private Date operation_edate;
    private String authority;
    private int max_capacity;
    private int sdistance;
    private int edistance;
}

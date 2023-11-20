package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchStatistics {
    private Date sdate;
    private Date edate;
}

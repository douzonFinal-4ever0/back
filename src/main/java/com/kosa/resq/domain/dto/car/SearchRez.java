package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRez {
    private int rez_status;
    private Date rez_start_at;
    private Date rez_end_at;
    private Date oper_start_at;
    private Date oper_end_at;
    private String dept_name;

}

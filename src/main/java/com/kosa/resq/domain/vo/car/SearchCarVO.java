package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCarVO {
    private String operation_sdate;
    private String operation_edate;
    private String authority;
    private int max_capacity;
    private int sdistance;
    private int edistance;
}

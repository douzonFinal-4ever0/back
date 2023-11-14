package com.kosa.resq.domain.dto.mr.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezRankDTO {
    private String mr_code;
    private String mr_name;
    private int rez_cnt;
}

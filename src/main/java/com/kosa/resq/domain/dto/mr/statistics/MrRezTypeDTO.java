package com.kosa.resq.domain.dto.mr.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezTypeDTO {
    private String mr_type;
    private int rez_cnt;
}

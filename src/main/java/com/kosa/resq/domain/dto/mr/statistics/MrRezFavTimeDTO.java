package com.kosa.resq.domain.dto.mr.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezFavTimeDTO {
    private String rez_time;
    private int rez_cnt;
}

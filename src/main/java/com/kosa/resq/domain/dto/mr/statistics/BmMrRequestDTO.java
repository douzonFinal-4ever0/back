package com.kosa.resq.domain.dto.mr.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmMrRequestDTO {
    private String mem_code;
    private String mr_code;
}

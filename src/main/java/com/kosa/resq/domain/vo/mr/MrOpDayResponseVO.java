package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrOpDayResponseVO {
    private int day;
    private String op_day_code;
    private String mr_code;
}

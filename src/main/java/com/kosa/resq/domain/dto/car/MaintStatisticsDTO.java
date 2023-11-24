package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintStatisticsDTO {
    private int type;
    private String car_code;
    private String car_name;
    private int count;
}

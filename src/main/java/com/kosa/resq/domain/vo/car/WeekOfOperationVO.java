package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekOfOperationVO {
    private int day_of_week;
    private int distance;
    private int nomal_biz_mileage;
    private int commute_mileage;
}

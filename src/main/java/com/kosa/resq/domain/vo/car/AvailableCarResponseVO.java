package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AvailableCarResponseVO {
    private String car_code;
    private String car_name;
    private String car_address;
    private String memo;
}

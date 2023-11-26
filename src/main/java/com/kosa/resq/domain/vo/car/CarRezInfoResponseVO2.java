package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRezInfoResponseVO2 {
    private String car_rez_code;
    private String car_code;
    private Date start_at;
    private Date return_at;
}

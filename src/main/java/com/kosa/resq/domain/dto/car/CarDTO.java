package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {
    private String car_code;
    private String car_name;
    private String type;
    private String fuel_type;
    private String authority;
    private Date buy_at;
    private String memo;
    private Date created_at;
}

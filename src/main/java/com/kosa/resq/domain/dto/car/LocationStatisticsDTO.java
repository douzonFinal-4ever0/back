package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationStatisticsDTO {

    private String car_rez_code;
    private double latitude;
    private double longitude;
    private String address;
}

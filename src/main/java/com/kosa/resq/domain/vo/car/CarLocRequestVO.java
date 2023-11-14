package com.kosa.resq.domain.vo.car;

import com.kosa.resq.domain.dto.car.CarDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.dto.common.MemDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarLocRequestVO {
    private String loc_code;
    private String loc_type;
    private double latitude;
    private double longitude;
    private String address;
    private String car_rez_code;
    private String mem_code;
    private String car_code;
}

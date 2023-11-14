package com.kosa.resq.domain.vo.car;

import com.kosa.resq.domain.dto.car.CarDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.dto.common.MemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarLocResponseVO {
    private String loc_code;
    private String loc_type;
    private double latitude;
    private double longitude;
    private String address;
    private CarRezDTO carRezDTO;
    private MemDTO memDTO;
    private CarDTO carDTO;
}

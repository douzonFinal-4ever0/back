package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarLocDTO {
    private String loc_code;
    private String loc_type;
    private double latitude;
    private double longitude;
    private String address;
    private CarRezDTO carRezDTO;
    private MemDTO memDTO;
    private CarDTO carDTO;
}

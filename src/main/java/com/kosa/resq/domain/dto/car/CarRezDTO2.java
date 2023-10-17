package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRezDTO2 {
    private String car_rez_code;
    private String rez_at;
    private String detail;
    private float est_mileage;
    private String rez_status;
    private Date start_at;//대여일자
    private Date return_at;
    private Date updated_at;
    private MemDTO memDTO;
    private CarDTO carDTO;
    private List<CarLocDTO> carLoc;
}

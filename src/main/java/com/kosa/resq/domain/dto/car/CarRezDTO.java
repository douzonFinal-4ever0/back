package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.dto.common.MemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRezDTO {
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
    private String receipt_loc;//인수장소
    private String return_loc;//반납장소
    private String dest_loc;//목적지
}

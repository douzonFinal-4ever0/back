package com.kosa.resq.domain.vo.car;

import com.kosa.resq.domain.vo.common.MemResponseVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarRezResponseVO {
    private String car_rez_code;
    private Date rez_at;
    private String detail;
    private float est_mileage;
    private String rez_status;
    private Date start_at;
    private Date return_at;
    private Date updated_at;
    private MemResponseVO memResponseVO;
    private CarDetailResponseVO carDetailResponseVO;
}

package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUserRequestVO {
    private String car_code;
    private String mem_code;
    private Date created_at;
    private Date updated_at;
}

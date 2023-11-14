package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUserDTO {

    private String mem_code;
    private String car_code;
    private Date created_at;
    private Date updated_at;
}

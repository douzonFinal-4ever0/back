package com.kosa.resq.domain.vo.car;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarUserResponseVO {
    private String mem_code;
    private String dept_code;
    private String position_name;
    private String name;
    private String dept_name;
}

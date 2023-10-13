package com.kosa.resq.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptDTO {
    private String dept_code;
    private String dept_name;
    private String dept_tel;
    private String dept_head_code;
    private String location;
}

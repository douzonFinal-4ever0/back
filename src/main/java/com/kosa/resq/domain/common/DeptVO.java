package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
    private String dept_code;
    private String dept_name;
    private String dept_tel;
    private String dept_head_code;
    private String location;
}

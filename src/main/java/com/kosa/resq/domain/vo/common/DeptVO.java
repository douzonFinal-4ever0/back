package com.kosa.resq.domain.vo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptVO {
    private String dept_code;
    private String dept_name;
    private String dept_tel;
    private String dept_head_code;
    private String location;
}

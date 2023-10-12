package com.kosa.resq.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemDTO {
    private String mem_code;
    private String position_name;
    private String name;
    private String email;
    private String password;
    private String role;
    private Date hired_at;
    private Date created_at;
    private String address;
    private String tel;
    private int is_worked;
    private String profile_img_url;
    private DeptDTO deptDTO;
}

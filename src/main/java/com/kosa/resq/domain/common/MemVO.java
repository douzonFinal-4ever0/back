package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemVO {
    private String mem_code;
    private String name;
    private String email;
    private String password;
    private String role;
    private Date hired_at;
    private Date created_at;
    private String address;
    private int al_date_cnt;
    private String tel;
    private String ssn;
    private int is_worked;
    private String profile_img_url;
    private DeptVO dept;
    private PositionVO position;
}

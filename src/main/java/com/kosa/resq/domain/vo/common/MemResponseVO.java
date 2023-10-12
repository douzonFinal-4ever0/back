package com.kosa.resq.domain.vo.common;

import com.kosa.resq.domain.dto.common.DeptDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemResponseVO {
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

package com.kosa.resq.domain.dto.common;

import lombok.*;

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

    @Builder
    MemDTO(String mem_code,
           String name,
           String email,
           String password,
           String role,
           int is_worked){
        this.mem_code=mem_code;
        this.password=password;
        this.name=name;
        this.is_worked=is_worked;
        this.email=email;
        this.role=role;
    }
}

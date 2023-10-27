package com.kosa.resq.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemResponseDTO {
    private String mem_code;
    private String dept_code;
    private String position_name;
    private String name;
    private String email;
    private String role;
    private String profile_img_url;

}

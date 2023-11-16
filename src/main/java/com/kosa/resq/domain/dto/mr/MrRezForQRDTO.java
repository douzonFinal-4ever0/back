package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezForQRDTO {
    private String mr_rez_code;
    private String mem_code;
    private String mr_code;
    private String m_name;
    private String rez_date;
    private String start_time;
    private String end_time;
    private String name;
    private String position_name;
    private String dept_name;
}

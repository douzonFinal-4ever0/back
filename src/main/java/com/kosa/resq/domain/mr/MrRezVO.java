package com.kosa.resq.domain.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MrRezVO {
    private String mr_rez_code;
    private String rez_person;
    private Date rez_start_time;
    private Date rez_end_time;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private String rez_status;
    private String m_purpose;
    private String m_type;
    private MrVO mrVO;
}

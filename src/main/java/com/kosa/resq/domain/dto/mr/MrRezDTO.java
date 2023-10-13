package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MrRezDTO {
    private String mr_rez_code;
    private Date rez_start_time;
    private Date rez_end_time;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private String rez_status;
    private String m_purpose;
    private String m_type;
    private int is_confirmed;
    private int rez_type;
    private List<MrDTO> mr;
}

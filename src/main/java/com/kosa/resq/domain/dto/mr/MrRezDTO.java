package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezDTO {
    private String mr_rez_code;
    private String rez_start_time;
    private String rez_end_time;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String rez_status;
    private String m_purpose;
    private String m_type;
    private int is_confirmed;
    private int rez_type;
    private List<MrDTO> mr;
}

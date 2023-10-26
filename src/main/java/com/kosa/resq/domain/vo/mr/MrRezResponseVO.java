package com.kosa.resq.domain.vo.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezResponseVO {
    private String mr_rez_code;
    private String rez_start_time;
    private String rez_end_time;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String rez_status;
    private String m_name;
    private String m_type;
    private int is_confirmed;
    private int rez_type;
    private MrResponseVO mr;
}

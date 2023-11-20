package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezParticipantDTO {
    private String mr_rez_code;
    private String name;
    private String position_name;
    private String dept_name;
}

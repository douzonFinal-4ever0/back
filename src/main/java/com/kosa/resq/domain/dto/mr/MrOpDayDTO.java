package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MrOpDayDTO {
    private int day;
    private String op_day_code;
//    private List<MrDTO> mrDTO;
}

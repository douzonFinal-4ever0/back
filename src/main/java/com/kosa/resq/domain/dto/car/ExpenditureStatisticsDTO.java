package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenditureStatisticsDTO {
    private int total;
    private List<ExpenditureDTO> expenditureDTOS;

}

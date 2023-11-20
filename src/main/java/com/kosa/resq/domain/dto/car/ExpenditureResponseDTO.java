package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.vo.car.ExpenditureResponseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenditureResponseDTO {
    private int day_of_week;
    private List<ExpenditureResponseVO> expenditureDTOS;
}

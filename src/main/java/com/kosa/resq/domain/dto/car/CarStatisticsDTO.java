package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.vo.car.CarStatisticsVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarStatisticsDTO {

    private int totalCount;
    private int operationCarCount;
    private List<CarStatisticsVO> maxOperCar;
}

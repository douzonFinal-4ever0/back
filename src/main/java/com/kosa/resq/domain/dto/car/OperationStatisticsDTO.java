package com.kosa.resq.domain.dto.car;

import com.kosa.resq.domain.vo.car.WeekOfOperationVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationStatisticsDTO {
    private int totalDistance;
    private List<WeekOfOperationVO> weekOfOperationVOList;
    private int lastTotalDistance;
}

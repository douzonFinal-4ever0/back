package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarMaintItemResponseVO {

    private List<CarMaintResponseVO> carMaintItemList;
    private List<MaintComResponseVO> maintComList;
}

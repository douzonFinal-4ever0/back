package com.kosa.resq.domain.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MrSuppliesVO {
    private MrVO mrVO;
    private SuppliesVO suppliesVO;
    private int amount;
}

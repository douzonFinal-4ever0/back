package com.kosa.resq.domain.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuppliesRezVO {
    private String supplies_rez_code;
    private int rez_amount;
    private SuppliesVO suppliesVO;
    private MrRezVO mrRezVO;
}

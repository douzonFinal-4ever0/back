package com.kosa.resq.domain.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuppliesVO {
    private String supplies_code;
    private String supplies_name;
    private int stock_amount;
    private String unit;
}

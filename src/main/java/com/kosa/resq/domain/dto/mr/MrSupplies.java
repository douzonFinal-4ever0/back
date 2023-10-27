package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrSupplies {
    private String mr_code;
    private String supplies_code;
    private int amount;
}

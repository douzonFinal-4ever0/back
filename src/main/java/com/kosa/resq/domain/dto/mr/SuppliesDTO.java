package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuppliesDTO {
    private String supplies_code;
    private String supplies_name;
    private int stock_amount;
    private String unit;
    private String type;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}

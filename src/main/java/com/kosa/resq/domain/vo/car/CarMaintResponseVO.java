package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarMaintResponseVO {

    private String maint_item_code;
    private String maint_name;
    private int cycle;
    private int type;
}

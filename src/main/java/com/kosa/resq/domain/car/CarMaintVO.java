package com.kosa.resq.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarMaintVO {
    private String maint_item_code;
    private String maint_name;
    private Date cycle;
    private int type;
}

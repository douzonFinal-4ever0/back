package com.kosa.resq.domain.vo.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintComResponseVO {

    private String  mc_code;
    private String mc_name;
    private String mc_tell;
    private int mc_category;
}

package com.kosa.resq.domain.car;

import com.kosa.resq.domain.common.MemVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MaintRecordVO {
    private String maint_code;
    private Date maint_at;
    private int maint_cost;
    private String pay_method;
    private String manager;
    private String memo;
    private CarVO carVO;
    private CarMaintVO carMaintVO;
    private MaintComVO maintComVO;
    private MemVO memVO;
}

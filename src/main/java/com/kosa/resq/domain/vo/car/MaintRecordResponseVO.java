package com.kosa.resq.domain.vo.car;

import com.kosa.resq.domain.vo.common.MemResponseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintRecordResponseVO {

    private String maint_code;
    private String car_code;
    // 정비 항목 데이터
    private CarMaintResponseVO carMaintResponseVO;
    // 정비 업체 데이터
    private MaintComResponseVO maintComResponseVO;

    private MemResponseVO memResponseVO;
    private Date maint_start_at;
    private Date maint_end_at;
    private String maint_cost;
    private String pay_method;
    private String memo;
    private Date created_at;
    private Date updated_at;
    private List<String> url;
}

package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrPtRequestVO {
    private String mr_pt_code;
    private String mr_rez_code;
    private String mem_code;
    private String outside_code;

}

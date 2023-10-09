package com.kosa.resq.domain.mr;

import com.kosa.resq.domain.common.MemVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MrPtVO {
    private MrRezVO mrRezVO;
    private String pt_type;
    private MemVO memVO;
    private OutsiderVO outsiderVO;
}

package com.kosa.resq.domain.mr;

import com.kosa.resq.domain.common.MemVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BmGroupMemVO {
    private String bm_code;
    private BmGroupVO bmGroupVO;
    private MemVO memVO;
}

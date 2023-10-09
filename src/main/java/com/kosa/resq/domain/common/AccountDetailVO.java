package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailVO {
    private String ac_detail_code;
    private String ac_detail_name;
    private AccountVO accountVO;
}

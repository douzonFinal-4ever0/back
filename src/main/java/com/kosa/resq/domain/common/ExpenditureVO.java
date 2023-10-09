package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenditureVO {
    private String exp_code;
    private Date exp_at;
    private String exp_content;
    private int cost;
    private String status;
    private Date created_at;
    private Date updated_at;
    private String url;
    private AccountDetailVO accountDetailVO;
}

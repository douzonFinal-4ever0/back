package com.kosa.resq.domain.vo.car;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExpenditureRequestVO {
    private String exp_code;
    private Date exp_at;
    private String exp_content;
    private int cost;
    private String url;
    private String account;
    private String ac_detail;
    private String pay_method;
    private String mem_code;
    private Date created_at;
    private Date updated_at;
}

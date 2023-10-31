package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExpenditureDTO {
    private String exp_code;
    private Date exp_at;
    private String exp_content;
    private int cost;
    private String status;
    private String url;
    private String account;
    private String ac_detail;
    private String pay_method;
    private String mem_code;
}

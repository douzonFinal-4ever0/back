package com.kosa.resq.domain.vo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlertResponseVO {
    private String alert_code;
    private String mem_code;
    private String alert_at;
    private int is_read;
    private String contents;
}

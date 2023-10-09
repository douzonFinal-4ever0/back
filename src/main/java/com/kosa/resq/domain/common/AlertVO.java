package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlertVO {
    private String alert_code;
    private Date alert_at;
    private int is_read;
    private MemVO memVO;
    private AlertMsgVO alertMsgVO;
}

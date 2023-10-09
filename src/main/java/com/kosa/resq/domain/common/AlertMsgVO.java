package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlertMsgVO {
    private String msg_code;
    private String contents;
}

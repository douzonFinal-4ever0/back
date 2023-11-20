package com.kosa.resq.domain.vo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlertRequestVO {
    private String alert_code;
    private String mem_code;
    private String alert_at;
    private int is_read;
    private String contents;
    public AlertRequestVO(String mem_code, String contents){
        this.alert_at=null;
        this.mem_code=mem_code;
        this.alert_at=null;
        this.is_read=0;
        this.contents=contents;
    }
    public AlertRequestVO(String contents){
        this.alert_at=null;
        this.mem_code=null;
        this.alert_at=null;
        this.is_read=0;
        this.contents=contents;
    }
}

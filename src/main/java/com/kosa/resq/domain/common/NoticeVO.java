package com.kosa.resq.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeVO {
    private String notice_code;
    private Date created_at;
    private Date updated_at;
    private String contents;
    private String attached_file_url;
    private MemVO memVO;
}

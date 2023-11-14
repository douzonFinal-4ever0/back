package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
    private String notice_code;
    private String created_at;
    private String updated_at;
    private String deleted_at;
    private String contents;
    private int is_opened;
    private String notice_title;
    private List<NoticeFileDTO> notice_file;
    private String mem_code;
}

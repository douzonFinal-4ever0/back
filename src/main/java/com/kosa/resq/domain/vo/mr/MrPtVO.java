package com.kosa.resq.domain.vo.mr;

import com.kosa.resq.domain.vo.common.MemResponseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrPtVO {
    private String mr_pt_code; // 참석자 번호
    private String mr_rez_code; // 회의실 예약 번호
    private String mem_code; // 사번
    private Date created_at; // 등록일자
    private Date updated_at; // 변경일자
    private Date deleted_at; // 삭제일자
    private MemResponseVO memVO;
}

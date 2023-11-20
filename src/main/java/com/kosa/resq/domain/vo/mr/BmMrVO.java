package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmMrVO {
    public String bm_mr_code; // 즐겨찾기 회의실 번호
    public String mem_code; // 사원 번호
    public String mr_code; // 회의실 번호
    private Date created_at; // 등록일자
    private Date updated_at; // 변경일자
    private Date deleted_at; // 삭제일자
    private MrResponseVO mr; //회의실
}

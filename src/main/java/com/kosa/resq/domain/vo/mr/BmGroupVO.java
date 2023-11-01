package com.kosa.resq.domain.vo.mr;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmGroupVO {
    private String bm_group_code; // 즐겨찾기 그룹 번호
    private String mem_code; // 사번 (소유자)
    private String bm_group_name; // 그룹명
    private Date created_at; // 등록일자
    private Date updated_at; // 변경일자
    private Date deleted_at; // 삭제일자
}

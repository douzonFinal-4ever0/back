package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmGroupMemVO {
    private String bm_code; // 즐겨찾기 번호
    private String bm_group_code; // 즐겨찾기 그룹 번호 (*개인이면 null)
    private String mem_code; // 사번 (지정자)
    private Date created_at; // 등록일자
    private Date updated_at; // 변경일자
    private Date deleted_at; // 삭제일자
}


package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmGroupMemVO {
    private String bm_code; // 즐겨찾기 번호
    private String bm_group_code; // 즐겨찾기 그룹 번호 (*개인이면 null)
    private String mem_code; // 사번 (지정자)
}

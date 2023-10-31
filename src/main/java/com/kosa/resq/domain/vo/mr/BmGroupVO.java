package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmGroupVO {
    private String bm_group_code; // 즐겨찾기 그룹 번호
    private String mem_code; // 사번 (소유자)
    private String bm_group_name; // 그룹명
}

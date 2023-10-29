package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmGroupMemResponseDTO {
    private String bm_group_code; // 즐겨찾기 그룹 번호
    private String bm_group_name; // 즐겨찾기 그룹명
    private String mem_code; // 사번 (지정자)
    private String name; // 이름 
    private String position_name; // 직급
    private String email; // 이메일
    private String profile_img_url; // 프로필 이미지 url
    private String tel; // 연락처
    private String dept_name; // 부서명
}

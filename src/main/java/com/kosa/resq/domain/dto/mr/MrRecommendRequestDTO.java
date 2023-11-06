package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MrRecommendRequestDTO {
    private String mem_code; // 사번
    private String m_type; // 회의 종류 (프로젝트회의, 화상회의 등..)
    private String rez_date; // 예약 일자 (년월일)
    private String rez_start_time; // 예약 시작 시간
    private String rez_end_time; // 예약 종료 시간
    private int tot_pt_ctn; // 총 인원수
}

package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MrRezRequestDTO {
    private String mr_code; // 회의실 번호
    private String mem_code; // 사번
    private String m_name; // 회의명
    private String m_type; // 회의 종류 (프로젝트회의, 화상회의 등..)
    private String rez_date; // 예약 일자 (년월일)
    private String rez_start_time; // 예약 시작 시간
    private String rez_end_time; // 예약 종료 시간
    private int tot_pt_ctn; // 총 인원수
    private int rez_type; // 예약 구분 (0:일반예약/1:정기예약)
    private List<String> mr_pt_list; // 회의 참석자 리스트 (사원 번호)
}

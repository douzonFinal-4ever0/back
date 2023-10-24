package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezRequestVO {
    private String mr_rez_code; // 회의실 예약 번호
    private String mem_code; // 사번
    private String mr_code; // 회의실 번호
    private Date rez_start_time; // 예약 시작 시간
    private Date rez_end_time; // 예약 종료 시간
    private Date created_at; // 등록 일자
    private Date updated_at; // 변경 일자
    private Date deleted_at; // 취소 일자
    private String rez_status; // 예약 상태
    private String m_name; // 회의명
    private String m_type; // 회의 종류 (프로젝트회의, 화상회의 등..)
    private int is_confirmed; // 예약 승인 여부 (0:승인/1:반려)
    private int rez_type; // 예약 구분 (0:일반예약/1:정기예약)
    private int tot_pt_ctn; // 총 인원수
}

package com.kosa.resq.domain.vo.mr;

import com.kosa.resq.domain.dto.mr.MrImgDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrOpDayDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrResponseVO {
    private String mr_code;
    private String mr_name;
    private int maximum_capacity;
    private String location;
    private Date avl_start_time;
    private Date avl_end_time;
    private int is_opened;
    private int is_used;
    private String mr_type;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
    private List<MrKeywordResponseVO> mr_keyword;
    private List<MrImgResponseVO> mr_img;
    private List<MrOpDayResponseVO> mr_op_day;
    private int priority; // 우선순위
}

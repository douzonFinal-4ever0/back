package com.kosa.resq.domain.dto.mr;

import com.kosa.resq.domain.vo.mr.MrOpDayVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MrDTO {
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
    private List<MrKeyWordDTO> mr_keyword;
    private List<MrImgDTO> mr_img;
    private List<MrOpDayDTO> mr_op_day;
}

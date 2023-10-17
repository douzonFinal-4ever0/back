package com.kosa.resq.domain.dto.mr;

import com.kosa.resq.domain.vo.mr.MrOpDayVO;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MrDTO {
    private String mr_code;
    private String mr_name;
    private int maximum_capacity;
    private String location;
    private String avl_start_time;
    private String avl_end_time;
    private int is_opened;
    private int is_used;
    private String mr_type;
    private String created_at;
    private String  updated_at;
    private String  deleted_at;
    private List<MrKeyWordDTO> mr_keyword;
    private List<MrImgDTO> mr_img;
    private List<MrOpDayDTO> mr_op_day;
}

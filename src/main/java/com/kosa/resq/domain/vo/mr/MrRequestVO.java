package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MrRequestVO {
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
}

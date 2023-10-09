package com.kosa.resq.domain.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MrVO {
    private String mr_code;
    private String mr_name;
    private int maximum_capacity;
    private String location;
    private int avl_day;
    private Date avl_start_time;
    private Date avl_end_time;
    private int is_opened;
    private int is_used;
    private MrTypeVO mrTypeVO;
}

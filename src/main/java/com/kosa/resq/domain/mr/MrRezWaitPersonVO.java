package com.kosa.resq.domain.mr;

import com.kosa.resq.domain.common.MemVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MrRezWaitPersonVO {
    private MemVO memVO;
    private int wait_person_num;
    private Date hp_avl_start_time;
    private Date hp_avl_end_time;
    private Date hp_wait_start_time;
    private Date hp_wait_end_time;
}

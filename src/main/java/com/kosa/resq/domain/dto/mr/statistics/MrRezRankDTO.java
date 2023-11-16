package com.kosa.resq.domain.dto.mr.statistics;

import com.kosa.resq.domain.dto.mr.MrImgDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrRezRankDTO {
    private String mr_code;
    private String mr_name;
    private int rez_cnt;
    private String img_url;
}

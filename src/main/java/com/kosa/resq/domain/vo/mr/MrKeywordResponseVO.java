package com.kosa.resq.domain.vo.mr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MrKeywordResponseVO {
    private String keyword_code;
    private String keyword_name;
    private String mr_code;
}

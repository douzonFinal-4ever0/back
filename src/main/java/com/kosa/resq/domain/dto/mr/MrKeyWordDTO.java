package com.kosa.resq.domain.dto.mr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MrKeyWordDTO {
    private String keyword_code;
    private String keyword_name;
    private String mr_code;
}

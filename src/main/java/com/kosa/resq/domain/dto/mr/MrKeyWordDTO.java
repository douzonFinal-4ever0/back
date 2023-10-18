package com.kosa.resq.domain.dto.mr;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MrKeyWordDTO {
    private String keyword_code;
    private String keyword_name;
    private String mr_code;
}

package com.kosa.resq.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseVO {
    private String license_code;
    private String type;
    private Date expir_at;
    private Date issue_at;
    private String url;
}

package com.kosa.resq.domain.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDamageVO {
    private String damage_code;
    private int cost;
    private String content;
    private Date damage_at;
    private String etc;
    private int is_insurance;
    private Date start_at;
    private Date end_at;
}

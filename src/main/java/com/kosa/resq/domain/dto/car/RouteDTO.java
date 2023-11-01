package com.kosa.resq.domain.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouteDTO {
    private Float[] receipt_loc;
    private Float[] return_loc;
    private Float[] dest_loc;
}

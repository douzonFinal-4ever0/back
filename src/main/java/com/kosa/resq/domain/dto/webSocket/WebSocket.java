package com.kosa.resq.domain.dto.webSocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebSocket {
    private String username;
    private String content;
    private Date date;
}

package com.kosa.resq.domain.dto.common;

import lombok.Data;

@Data
public class ChatDto {
    private Integer channelId;
    private Integer writerId;
    private String chat;
}

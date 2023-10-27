package com.kosa.resq.config.security.code;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum SuccessCode {
    /**
     * ******************************* Success CodeList ***************************************
     */
    // 조회 성공 코드 (HTTP Response: 200 OK)
    SELECT(200, "200", "SELECT SUCCESS"),
    // 삭제 성공 코드 (HTTP Response: 200 OK)
    DELETE(200, "200", "DELETE SUCCESS"),

    // 전송 성공 코드 (HTTP Response: 200 OK)
    SEND(200, "200", "SEND SUCCESS"),


    // 삽입 성공 코드 (HTTP Response: 201 Created)
    INSERT(201, "201", "INSERT SUCCESS"),
    // 수정 성공 코드 (HTTP Response: 201 Created)
    UPDATE(204, "204", "UPDATE SUCCESS"),

    ; // End

    /**
     * ******************************* Success Code Constructor ***************************************
     */
    // 성공 코드의 '코드 상태'를 반환한다.
    private int status;

    // 성공 코드의 '코드 값'을 반환한다.
    private String code;

    // 성공 코드의 '코드 메시지'를 반환한다.s
    private String message;

    // 생성자 구성
    SuccessCode(final int status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}

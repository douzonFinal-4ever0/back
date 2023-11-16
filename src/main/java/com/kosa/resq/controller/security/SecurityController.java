package com.kosa.resq.controller.security;

import com.kosa.resq.config.security.ApiResponse;
import com.kosa.resq.config.security.AuthConstants;
import com.kosa.resq.config.security.code.SuccessCode;
import com.kosa.resq.config.security.util.TokenUtil;
import com.kosa.resq.domain.dto.common.MemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SecurityController {
    @PostMapping("/api/v1/user/login")
    public void login(){
    }
    @PostMapping("/test/generateToken")
    public ResponseEntity<ApiResponse> selectCodeList(@RequestBody MemDTO mem) {

        String resultToken = TokenUtil.generateJwtToken(mem);

        ApiResponse ar = ApiResponse.builder()
                // BEARER {토큰} 형태로 반환을 해줍니다.
                .result(AuthConstants.TOKEN_TYPE + " " + resultToken)
                .resultCode(SuccessCode.SELECT.getStatus())
                .resultMsg(SuccessCode.SELECT.getMessage())
                .build();

        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
}

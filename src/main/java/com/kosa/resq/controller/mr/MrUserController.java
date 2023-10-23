package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.MrRezRequestDTO;
import com.kosa.resq.service.mr.MrUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mr")
@Log4j2
public class MrUserController {
    @Autowired
    private MrUserService service;

    @PostMapping("/rez")
    public ResponseEntity<String> mrRezSave(@RequestBody MrRezRequestDTO requestDTO) {
        log.info("[POST] mrRezSave 컨트롤러 ============");
        log.info(requestDTO);
        service.mrRezSave(requestDTO);
        return ResponseEntity.ok("success");
    }
}

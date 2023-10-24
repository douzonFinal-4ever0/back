package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.MrRezRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mr")
@Log4j2
public class MrUserController {

    @PostMapping("/rez")
    public ResponseEntity<String> mrRezSave(@RequestBody MrRezRequestDTO requestDTO) {
        String m_name = requestDTO.getM_name();
        log.info("=========여기========");
        log.info(requestDTO);
        return ResponseEntity.ok("res: " + m_name);
    }
}

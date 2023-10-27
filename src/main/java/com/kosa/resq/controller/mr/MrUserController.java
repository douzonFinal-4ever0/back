package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrRecommendRequestDTO;
import com.kosa.resq.domain.dto.mr.MrRezRequestDTO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.service.mr.MrUserService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mr")
@Log4j2
public class MrUserController {
    @Autowired
    private MrUserService service;

    @GetMapping("/recommend")
    public ResponseEntity<List<MrResponseVO>> mrRecommendGetAll(@ModelAttribute MrRecommendRequestDTO mrRecommendRequestDTO) {
        log.info("[GET] mrRecommendGetAll 컨트롤러 ============");
        List<MrResponseVO> result = service.mrRecommendGetAll(mrRecommendRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/rez")
    public ResponseEntity<String> mrRezSave(@RequestBody MrRezRequestDTO requestDTO) {
        log.info("[POST] mrRezSave 컨트롤러 ============");
        log.info(requestDTO);
        service.mrRezSave(requestDTO);
        return ResponseEntity.ok("success");
    }

//    @GetMapping("/mem")
//    public ResponseEntity<List<MemResponseVO>> memGatAll() {
//        List<MemResponseVO> result = service.memGatAll();
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}

package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.BmMrVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.service.mr.MrUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mr")
@Log4j2
public class MrUserController {
    @Autowired
    private MrUserService service;

    @GetMapping("/recommend") // 회의실 추천 조회
    public ResponseEntity<List<MrResponseVO>> mrRecommendGetAll(@ModelAttribute MrRecommendRequestDTO mrRecommendRequestDTO) {
        log.info(mrRecommendRequestDTO);
        List<MrResponseVO> result = service.mrRecommendGetAll(mrRecommendRequestDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping("/rez") // 회의실 예약 등록
    public ResponseEntity<String> mrRezSave(@RequestBody MrRezRequestDTO requestDTO) {
        service.mrRezSave(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @GetMapping("/mem") // 멤버 전체 조회
    public ResponseEntity<List<MemResponseVO>> memGatAll() {
        List<MemResponseVO> result = service.memGatAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    @GetMapping("/mem/bm")  // 즐겨찾기 조회
    public ResponseEntity<List<BmGroupMemResponseDTO>> bmGroupMemGetAll(@RequestParam("mem_code") String mem_code) {
        List<BmGroupMemResponseDTO> result = service.bmGroupMemGetAll(mem_code);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/mem/bm") // 즐겨찾기 삭제
    public ResponseEntity<String> bmGroupMemDelete(@RequestBody Map<String, Object> requestBody) {
        List<String> deleteMemCodeList = (List<String>) requestBody.get("deleteMemCodeList");
        return ResponseEntity.ok("mem delete ");
    }

    @PostMapping("/mem/bm") // 즐겨찾기 그룹 멤버 등록
    public ResponseEntity<String> bmGroupSave(@RequestBody BmGroupRequestDTO requestBody) {
        log.info("==================즐겨찾기 그룹 컨트롤러==================");
        log.info(requestBody);
        service.bmGroupMemSave(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @GetMapping("/bm") // 즐겨찾기 회의실 조회
    public ResponseEntity<List<BmMrVO>> bmMrGetAll(@RequestParam("mem_code") String mem_code) {
        log.info("==================즐겨찾기 회의실 컨트롤러==================");
        List<BmMrVO> result = service.bmMrGetAll(mem_code);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

}

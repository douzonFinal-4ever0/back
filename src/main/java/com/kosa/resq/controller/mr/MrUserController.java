package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.dto.mr.statistics.BmMrRequestDTO;
import com.kosa.resq.domain.dto.mr.statistics.MrRezFavTimeDTO;
import com.kosa.resq.domain.dto.mr.statistics.RezStatisticsDTO;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.mr.BmMrVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.domain.vo.mr.MrRezResponseVO;
import com.kosa.resq.domain.vo.mr.ParticipantPerRezVO;
import com.kosa.resq.exception.DuplicateReservationException;
import com.kosa.resq.service.mr.MrUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @GetMapping("/rez") // 내가 예약한 회의실 내역 조회
    public ResponseEntity<List<MrRezResponseVO>> mrRezGetAllByMem(String mem_code) {
        List<MrRezResponseVO> result = service.mrRezGetAllByMem(mem_code);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/rez/pt") // 내가 참석자로 지정된 회의실 내역 조회
    public ResponseEntity<List<MrRezResponseVO>> mrRezGetAllByPt(String mem_code) {
        List<MrRezResponseVO> result = service.mrRezGetAllByPt(mem_code);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/rez") // 회의실 예약 등록
    public ResponseEntity<String> mrRezSave(@RequestBody MrRezRequestDTO requestDTO) {
        try {
            String mr_rez_code=service.mrRezSave(requestDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(mr_rez_code);
        } catch (DuplicateReservationException e) {
            // 중복 예약 예외 처리
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate reservation: " + e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @PutMapping("/rez") // 회의실 예약 수정
    public ResponseEntity<String> mrRezUpdate(@RequestBody MrRezRequestDTO requestDTO) {
        log.info("수정 컨트롤러 **************************");
        log.info(requestDTO);
        service.mrRezUpdate(requestDTO);
        //return ResponseEntity.status(HttpStatus.CREATED).body("success");
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @DeleteMapping("/rez") // 회의실 예약 삭제
    public ResponseEntity<String> mrRezDelete(@RequestParam("mr_rez_code") String mr_rez_code) {
        log.info("예약 삭제 컨트롤러 **************************");
        log.info(mr_rez_code);
        service.mrRezDelete(mr_rez_code);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }


    @GetMapping("/rez/recent") // 회의실 최근 예약 조회
    public ResponseEntity<List<MrRezResponseVO>> recentMrRezGetAll(String mem_code) {
        List<MrRezResponseVO> result = service.recentMrRezGetAll(mem_code);
        log.info(result);
        return  new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/mem") // 멤버 전체 조회
    public ResponseEntity<List<MemResponseVO>> memGatAll() {
        List<MemResponseVO> result = service.memGatAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/mem/bm") // 즐겨찾기 그룹 멤버 등록
    public ResponseEntity<String> bmGroupSave(@RequestBody BmGroupRequestDTO requestBody) {
        log.info("==================즐겨찾기 그룹 컨트롤러==================");
        log.info(requestBody);

        service.bmGroupMemSave(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
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



    @GetMapping("/bm") // 즐겨찾기 회의실 조회
    public ResponseEntity<List<BmMrVO>> bmMrGetAll(@RequestParam("mem_code") String mem_code) {
        log.info("==================즐겨찾기 회의실 컨트롤러==================");
        List<BmMrVO> result = service.bmMrGetAll(mem_code);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/bm") // 즐겨찾기 회의실 등록
    public ResponseEntity<String> bmMrSave(@RequestBody BmMrRequestDTO bmMrRequestDTO) {
        log.info("==================즐겨찾기 회의실  등록한다=================");
        log.info(bmMrRequestDTO);
        service.bmMrSave(bmMrRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }


    @GetMapping("/statistics") // 대시보드 회의실 통계
    public ResponseEntity<List<RezStatisticsDTO>> mrRezGetAll(@RequestParam("date") String date) throws ParseException {
        log.info("**************** 회의실 통계 ****************");
        log.info(date);
        // 1. 회의실 전체 예약 현황 카운트 (시간대별)
        List<RezStatisticsDTO> result = service.mrRezCharTwo(date);

//        List<MrRezResponseVO> result =  service.mrRezGetAllByDate(date);
            return new ResponseEntity<>(result, HttpStatus.OK);

//        return null;
    }

    @GetMapping("/participantPerRez")
    public List<ParticipantPerRezVO> participantPerRezGetAll(){
        System.out.println("asdasd");
        return service.participantPerRezGetAll();
    }

}

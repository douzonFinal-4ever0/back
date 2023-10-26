package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrRecommendRequestDTO;
import com.kosa.resq.domain.dto.mr.MrRezRequestDTO;
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
    public ResponseEntity<List<MrResponseVO>> mrRecommendGetAll(@RequestParam String m_type,
                                                                @RequestParam String rez_date,
                                                                @RequestParam String rez_start_time,
                                                                @RequestParam String rez_end_time,
                                                                @RequestParam int tot_pt_ctn) {
        log.info("[GET] mrRecommendGetAll 컨트롤러 ============");
        MrRecommendRequestDTO mrRecommendRequestDTO = new MrRecommendRequestDTO();
        mrRecommendRequestDTO.setM_type(m_type);
        mrRecommendRequestDTO.setRez_date(rez_date);
        mrRecommendRequestDTO.setRez_start_time(rez_start_time);
        mrRecommendRequestDTO.setRez_end_time(rez_end_time);
        mrRecommendRequestDTO.setTot_pt_ctn(tot_pt_ctn);

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
}

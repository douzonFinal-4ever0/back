package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.service.mr.MrAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mr")
public class MrAdminController {
    @Autowired
    private MrAdminService service;

    public MrAdminController(MrAdminService service) {
        this.service = service;
    }

    @GetMapping("/mrList")
    public List<MrDTO> mrGetAll() {
        return service.mrGetAll();
    }

    @GetMapping("/mrRez")
    public List<MrRezDTO> mrRezGetAll() {
        return service.mrRezGetAll();
    }

    @GetMapping("/notice")
    public List<NoticeDTO> noticeGetAll() {
        return service.noticeGetAll();
    }

    @PostMapping("/notice")
    public void noticeSave(@RequestBody NoticeDTO notice) {
        service.noticeSave(notice);
    }

    @PostMapping("/mrRegister")
    @Transactional
    public void mrSave(@RequestBody MrDTO mr) {
        List<MrKeyWordDTO> keyword = mr.getMr_keyword();
        List<MrOpDayDTO> mrOpDay = mr.getMr_op_day();

        // 먼저 MR 정보를 저장하고 mr_code를 가져옴
        service.mrSave(mr);
        String mrCode = mr.getMr_code(); // 이 부분은 mr 객체에 대한 getter를 사용

        // mr_code를 각 DTO에 설정하여 키워드 및 사용 가능한 날짜를 저장
        for (MrKeyWordDTO keywordDTO : keyword) {
            keywordDTO.setMr_code(mrCode);
            service.mrKeywordSave(keywordDTO);
        }

        for (MrOpDayDTO opDayDTO : mrOpDay) {
            opDayDTO.setMr_code(mrCode);
            service.mrAvailableDaySave(opDayDTO);
        }
    }

    @PatchMapping("/mrUpdate")
    public void mrUpdate(@RequestBody MrDTO mr){
        service.mrUpdate(mr);
    }

    @PatchMapping("/mrDeactivate")
    public void mrDeactivate(@RequestBody MrDTO mr){
        service.mrDeactivate(mr);
    }
}

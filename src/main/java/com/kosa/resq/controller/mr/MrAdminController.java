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
    public List<MrDTO> mrList() {
        return service.mrList();
    }

    @GetMapping("/mrRez")
    public List<MrRezDTO> mrRez() {
        return service.mrRez();
    }

    @GetMapping("/notice")
    public List<NoticeDTO> noticeList() {
        return service.noticeList();
    }

    @PostMapping("/notice")
    public void addNotice(@RequestBody NoticeDTO notice) {
        service.addNotice(notice);
    }

    @PostMapping("/mrRegister")
//    @Transactional
    public void addMr(@RequestBody MrDTO mr) {
//        service.addMr(mr);
        List<MrKeyWordDTO> keyword = mr.getMr_keyword();
        for (int i = 0; i < keyword.size(); i++) {
            System.out.println("keyWordName : " + keyword.get(i).getKeyword_name());
        }
        List<MrOpDayDTO> mrOpDay = mr.getMr_op_day();
//        System.out.println("mpOpDay : "+mrOpDay[0]);
    }
}

package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;
import com.kosa.resq.domain.dto.mr.NoticeDTO;
import com.kosa.resq.service.mr.MrAdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

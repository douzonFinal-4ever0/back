package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.MrDTO;
import com.kosa.resq.domain.dto.mr.MrKeyWordDTO;
import com.kosa.resq.domain.dto.mr.MrRezDTO;
import com.kosa.resq.service.mr.MrAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mr")
public class MrAdminController {
    @Autowired
    private MrAdminService service;

    public MrAdminController(MrAdminService service){
        this.service = service;
    }

    @GetMapping("/mrList")
    public List<MrDTO> mrList(){
        return service.mrList();
    }

    @GetMapping("/test")
    public List<MrDTO> test(){
        return service.test();
    }

    @GetMapping("/test2")
    public List<MrRezDTO> test2(){
        return service.test2();
    }
}

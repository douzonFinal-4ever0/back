package com.kosa.resq.controller.sp;

import com.kosa.resq.domain.dto.mr.SuppliesDTO;
import com.kosa.resq.service.mr.MrAdminService;
import com.kosa.resq.service.sp.SpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sp")
public class SpController {
    @Autowired
    private SpService service;

    public SpController(SpService service) {
        this.service = service;
    }

    @GetMapping("/spList")
    public List<SuppliesDTO> suppliesGetAll(){
        return service.suppliesGetAll();
    }
}

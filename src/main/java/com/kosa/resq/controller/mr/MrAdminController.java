package com.kosa.resq.controller.mr;

import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.dto.mr.statistics.*;
import com.kosa.resq.domain.vo.mr.TemplateVO;
import com.kosa.resq.service.S3UploadService;
import com.kosa.resq.service.mr.MrAdminService;
import com.kosa.resq.service.sp.SpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mr")
@Log4j2
public class MrAdminController {
    @Autowired
    private MrAdminService service;
    @Autowired
    private S3UploadService imgService;
    @Autowired
    private SpService spService;
    private String mrCode;


    public MrAdminController(MrAdminService service) {
        this.service = service;
    }

    @GetMapping("/mrList")
    public List<MrDTO> mrGetAll() {
        return service.mrGetAll();
    }

    @GetMapping("/{mr_code}")
    public MrDTO mrGetOne(@PathVariable String mr_code){
        return service.mrGetOne(mr_code);
    }
    @GetMapping("/mrRez")
    public List<MrRezDTO> mrRezGetAll() {
        return service.mrRezGetAll();
    }

    @GetMapping("/mrRez/{mr_rez_code}")
    public MrRezForQRDTO mrRezGetOne(@PathVariable String mr_rez_code){
        return service.mrRezGetOne(mr_rez_code);
    }
    @GetMapping("/mrRezPt/{mr_rez_code}")
    public List<MrRezParticipantDTO> mrRezPtGetAll(@PathVariable String mr_rez_code){
        return service.mrRezPtGetAll(mr_rez_code);
    }
    @GetMapping("/mrRezRank")
    public List<MrRezDTO> mrRezRank(){
        return service.mrRezRankGetAll();
    }
    @GetMapping("/mrRezTime")
    public List<MrRezTimeDTO> mrRezTime(){
        return service.mrRezTimeGetAll();
    }
    @GetMapping("/mrRezRow")
    public MrRezRowDTO mrRezRow(){
        return service.mrRezRowGetAll();
    }
    @GetMapping("/mrTypeRow")
    public List<MrRezTypeDTO> mrRezType(){
        return service.mrRezTypeGetAll();
    }
    @GetMapping("/mrRezDate")
    public List<MrRezDateDTO>mrRezDateGetAll(){
        return service.mrRezDateGetAll();
    }
    @GetMapping("/mrRezFavTime")
    public List<MrRezFavTimeDTO>mrRezFavTimeGetAll(){
        return service.mrRezFavTimeGetAll();
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
        List<MrSuppliesDTO> supplies = mr.getMr_supplies();

        // 먼저 MR 정보를 저장하고 mr_code를 가져옴
        service.mrSave(mr);
        mrCode = mr.getMr_code(); // 이 부분은 mr 객체에 대한 getter를 사용

        if(!keyword.isEmpty()){
            // mr_code를 각 DTO에 설정하여 키워드 및 사용 가능한 날짜를 저장
            for (MrKeyWordDTO keywordDTO : keyword) {
                keywordDTO.setMr_code(mrCode);
                service.mrKeywordSave(keywordDTO);
            }
        }

        if(!mrOpDay.isEmpty()){
            for (MrOpDayDTO opDayDTO : mrOpDay) {
                opDayDTO.setMr_code(mrCode);
                service.mrAvailableDaySave(opDayDTO);
            }
        }
//        if(!supplies.isEmpty()){
//            for(MrSuppliesDTO suppliesDTO: supplies){
//                suppliesDTO.setMr_code(mrCode);
//                spService.mrSuppliesSave(suppliesDTO);
//            }
//        }
    }

    @PatchMapping("/mrUpdate")
    public void mrUpdate(@RequestBody MrDTO mr) {
        List<MrKeyWordDTO> keyword = mr.getMr_keyword();
        List<MrOpDayDTO> mrOpDay = mr.getMr_op_day();
        service.mrUpdate(mr);
        mrCode = mr.getMr_code();

//        String mrCode = mr.getMr_code(); // 이 부분은 mr 객체에 대한 getter를 사용
        // mr_code를 각 DTO에 설정하여 키워드 및 사용 가능한 날짜를 저장
//        for (MrKeyWordDTO keywordDTO : keyword) {
//            keywordDTO.setMr_code(mrCode);
//            service.mrKeywordSave(keywordDTO);
//        }
        log.info(mrOpDay);
        log.info(mrCode);
//
        if(!mrOpDay.isEmpty()){
            for (int i = 0; i < mrOpDay.size(); i++) {
                MrOpDayDTO opDayDTO = mrOpDay.get(i);
                opDayDTO.setMr_code(mrCode);
                opDayDTO.setDay(i);
                service.mrOpDayUpdate(opDayDTO);
            }
        }

    }
    @PatchMapping("/mrCheckIn/{mr_code}")
    public void mrCheckIn(@PathVariable String mr_code) {
        service.mrCheckIn(mr_code);
    }
    @PatchMapping("/mrCheckOut/{mr_code}")
    public void mrCheckOut(@PathVariable String mr_code) {
        service.mrCheckOut(mr_code);
    }

    @PatchMapping("/mrDeactivate")
    public void mrDeactivate(@RequestBody MrDTO mr) {
        service.mrDeactivate(mr);
    }

    @GetMapping("/template")
    public List<TemplateVO> templateGetAll() {
        return service.templateGetAll();
    }

    @GetMapping("/notice/{notice_code}")
    public NoticeDTO noticeGetOne(@PathVariable String notice_code) {
        return service.noticeGetOne(notice_code);
    }

    @DeleteMapping("/notice/delete/{notice_code}")
    public void noticeDelete(@PathVariable String notice_code) {
        service.noticeDelete(notice_code);
    }

    @PostMapping("/mrImg")
    public ResponseEntity<Object> mrImgSave(@RequestParam("images") MultipartFile[] images) {
        try {
            for (MultipartFile image : images) {
                MrImgDTO img = new MrImgDTO();
                String url = imgService.saveFile(image, "mr");
                log.info(url);
                img.setUrl(url);
                System.out.println(mrCode);
                log.info(mrCode);
                img.setMr_code(mrCode);
                service.mrImgSave(img);
            }
        } catch (IOException e) {
            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Object>("Success", HttpStatus.OK);
//        service.mrImgSave(img);
    }
    @DeleteMapping("/mrImg/{img_code}")
    public void mrImgDelete(@PathVariable String img_code){
        service.mrImgDelete(img_code);
    }
}

package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.common.MemResquestVO;
import com.kosa.resq.domain.vo.mr.MrResponseVO;
import com.kosa.resq.domain.vo.mr.MrRezRequestVO;
import com.kosa.resq.mapper.mr.MrUserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class MrUserServiceImpl implements MrUserService {
    @Autowired
    private MrUserMapper mapper;

//    @Transactional
    @Override
    public void mrRezSave(MrRezRequestDTO mrRezRequestDTO) {
        try {
            log.info("mrRezRequestDTO");
            log.info(mrRezRequestDTO.getMr_pt_list());
            // ************[Start] 예약 시작 시간, 종료 시간 String => Date 변환 *****************
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            Date date = dateFormat.parse(mrRezRequestDTO.getRez_date());
            Date startTime = timeFormat.parse(mrRezRequestDTO.getRez_start_time());
            Date endTime = timeFormat.parse(mrRezRequestDTO.getRez_end_time());

            // Calendar 객체 생성
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();

            // date를 calendar에 설정
            calendar1.setTime(date);
            calendar2.setTime(date);

            // startTime을 calendar에 설정
            Calendar startTimeCalendar = Calendar.getInstance();
            startTimeCalendar.setTime(startTime);

            // endTime을 calendar에 설정
            Calendar endTimeCalendar = Calendar.getInstance();
            endTimeCalendar.setTime(endTime);

            // startTime 및 endTime의 년월일을 date 객체에 설정
            calendar1.set(Calendar.HOUR_OF_DAY, startTimeCalendar.get(Calendar.HOUR_OF_DAY));
            calendar1.set(Calendar.MINUTE, startTimeCalendar.get(Calendar.MINUTE));
            calendar1.set(Calendar.SECOND, startTimeCalendar.get(Calendar.SECOND));

            // endTime의 년월일을 date 객체에 설정
            calendar2.set(Calendar.HOUR_OF_DAY, endTimeCalendar.get(Calendar.HOUR_OF_DAY));
            calendar2.set(Calendar.MINUTE, endTimeCalendar.get(Calendar.MINUTE));
            calendar2.set(Calendar.SECOND, endTimeCalendar.get(Calendar.SECOND));

            // rez_start_time, rez_end_time
            Date rez_start_time = calendar1.getTime();
            Date rez_end_time = calendar2.getTime();
            // ************[End] 예약 시작 시간, 종료 시간 String => Date 변환 *****************

            MrRezRequestVO mrRezRequestVO = new MrRezRequestVO();
            mrRezRequestVO.setRez_start_time(rez_start_time);
            mrRezRequestVO.setRez_end_time(rez_end_time);
            mrRezRequestVO.setMem_code(mrRezRequestDTO.getMem_code());
            mrRezRequestVO.setMr_code(mrRezRequestDTO.getMr_code());
            mrRezRequestVO.setM_name(mrRezRequestDTO.getM_name());
            mrRezRequestVO.setM_type(mrRezRequestDTO.getM_type());
            mrRezRequestVO.setTot_pt_ctn(mrRezRequestDTO.getTot_pt_ctn());
            mrRezRequestVO.setRez_type(mrRezRequestDTO.getRez_type());

            mapper.mrRezSave(mrRezRequestVO);

        } catch(Exception e) {
            // 저장 실패 시 예외 처리
            e.printStackTrace();
        }
    }

    @Override
    public List<MrResponseVO> mrRecommendGetAll(MrRecommendRequestDTO mrRecommendRequestDTO) {
        log.info("================= mrRecommendGetAll 서비스 =============================");
        List<MrResponseVO> mr = mapper.mrRecommendGetAll(mrRecommendRequestDTO.getRez_date(),
                mrRecommendRequestDTO.getRez_start_time(), mrRecommendRequestDTO.getRez_end_time());
        return mr;
    }

    @Override
    public List<MemResponseVO> memGatAll() {
        return mapper.memGetAll();
    }

    @Override
    public List<BmGroupMemResponseDTO> bmGroupMemGetAll(String mem_code) {
        return mapper.bmGroupMemGetAll(mem_code);
    }

    @Transactional
    @Override
    public void bmGroupMemSave(BmGroupRequestDTO bmGroupRequestDTO) {
        log.info("+++++ 즐겨찾기 서비스 +++++");
        log.info(bmGroupRequestDTO.getGroupName());
        mapper.bmGroupSave(bmGroupRequestDTO.getGroupName(), bmGroupRequestDTO.getMaster());
        String bm_group_code = mapper.bmGroupGetOne(bmGroupRequestDTO.getMaster());
        for (String mem_code: bmGroupRequestDTO.getMembers()) {
            mapper.bmGroupMemSave(bm_group_code, mem_code);
        }
    }
}

package com.kosa.resq.service.mr;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.dto.common.MemResponseDTO;
import com.kosa.resq.domain.dto.mr.*;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import com.kosa.resq.domain.vo.common.MemResquestVO;
import com.kosa.resq.domain.vo.mr.*;
import com.kosa.resq.mapper.mr.MrUserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MrUserServiceImpl implements MrUserService {
    @Autowired
    private MrUserMapper mapper;

    @Transactional
    @Override
    public void mrRezSave(MrRezRequestDTO mrRezRequestDTO) {
        try {
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

            // 회의실 예약 데이터 추가
            mapper.mrRezSave(mrRezRequestVO);

            // 위의 생성된 회의실 예약 코드 가져오기
            String mr_rez_code = mrRezRequestVO.getMr_rez_code();

            // 회의 참석자 추가
            List<MemDTO> pt_list = mrRezRequestDTO.getMr_pt_list();
            for(MemDTO pt: pt_list) {
                String mem_code = pt.getMem_code();
                mapper.mrPtSave(mr_rez_code, mem_code);
            }

        } catch(Exception e) {
            // 저장 실패 시 예외 처리
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void mrRezUpdate(MrRezRequestDTO mrRezRequestDTO) {
        try {
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
            mrRezRequestVO.setMr_rez_code(mrRezRequestDTO.getMr_rez_code());

            // 회의실 예약 데이터 업데이트 (수정)
            mapper.mrRezUpdate(mrRezRequestVO);

            // 삭제 및 추가 로직을 별도의 메서드로 분리
            manageParticipants(mrRezRequestVO, mrRezRequestDTO.getMr_pt_list());

        } catch (ParseException e) {
            // 롤백이 필요한 경우 처리
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Transactional
    public void manageParticipants(MrRezRequestVO mrRezRequestVO, List<MemDTO> newParticipants) {
        try {
            // ************[Start] 참석자 관리 로직 *****************

            // 기존 회의 참석자 조회 후 사번 추출
            List<MrPtVO> originPtList = mapper.mrPtGetAllByRez(mrRezRequestVO.getMr_rez_code());
            List<String> origins = originPtList.stream()
                    .map(pt -> pt.getMemVO().getMem_code())
                    .collect(Collectors.toList());

            // 새롭게 전달받은 회의 참석자 사번 추출
            List<String> news = newParticipants.stream()
                    .map(MemDTO::getMem_code)
                    .collect(Collectors.toList());

            // 삭제해야 할 참석자 필터링하여 참석자 DB 삭제
            List<String> deletePts = new ArrayList<>(origins);
            deletePts.removeAll(news);
            deleteParticipants(deletePts, mrRezRequestVO.getMr_rez_code());

            // 추가해야 할 참석자 필터링하여 참석자 DB 추가
            List<String> addPts = new ArrayList<>(news);
            addPts.removeAll(origins);
            addParticipants(addPts, mrRezRequestVO.getMr_rez_code());

            // ************[End] 참석자 관리 로직 *****************

        } catch (Exception e) {
            // 롤백이 필요한 경우 처리
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Transactional
    public void deleteParticipants(List<String> deletePts, String mrRezCode) {
        try {
            log.info("기존 삭제");
            log.info(deletePts);

            if (!deletePts.isEmpty()) {
                for (String pt : deletePts) {
                    mapper.mrPtDelete(mrRezCode, pt);
                }
            }
        } catch (Exception e) {
            // 롤백이 필요한 경우 처리
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Transactional
    public void addParticipants(List<String> addPts, String mrRezCode) {
        try {
            log.info("새롭게 추가");
            log.info(addPts);

            if (!addPts.isEmpty()) {
                for (String pt : addPts) {
                    mapper.mrPtSave(mrRezCode, pt);
                }
            }
        } catch (Exception e) {
            // 롤백이 필요한 경우 처리
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
    }



    @Transactional
    @Override
    public void mrRezDelete(String mr_rez_code) {

        // 예약 삭제 -> deleted_at 업데이트
        mapper.mrRezDelete(mr_rez_code);


        // 참석자 삭제 -> deleted_at 업데이트
        // 1. 해당 참석자 조회
        List<MrPtVO> list =  mapper.mrPtGetAllByRez(mr_rez_code);
        for(MrPtVO pt : list) {
            // 2. 참석자 삭제
            mapper.mrPtDelete(mr_rez_code, pt.getMemVO().getMem_code());
        }

    }

    @Override
    public List<MrRezResponseVO> mrRezGetAllByMem(String mem_code) {
        log.info("************************");
        log.info(mapper.mrRezGetAllByMem(mem_code));
        return mapper.mrRezGetAllByMem(mem_code);
    }

    @Override
    public List<MrRezResponseVO> mrRezGetAllByPt(String mem_code) {
        List<String> rezList =  mapper.mrRezByPt(mem_code); // 내가 참석자로 지정된 회의실 예약 코드 모두 찾기
        List<MrRezResponseVO> result = new ArrayList<>();


        for (String mr_rez_code : rezList) {
            List<MrRezResponseVO> rezResponseVOS = mapper.mrRezGetAllByPt(mr_rez_code);
            for(MrRezResponseVO vo : rezResponseVOS) {
                result.add(vo);
            }

        }

        return result;
    }

    @Override
    public List<MrRezResponseVO> recentMrRezGetAll(String mem_code) {
        return mapper.recentMrRezGetAll(mem_code);
    }

    @Override
    public List<MrResponseVO> mrRecommendGetAll(MrRecommendRequestDTO mrRecommendRequestDTO) {
        log.info("================= mrRecommendGetAll 서비스 =============================");

        // *** 1차: 예약 가능한 회의실 조회
        List<MrResponseVO> avlMr = mapper.mrRecommendGetAll(mrRecommendRequestDTO.getRez_date(),
                mrRecommendRequestDTO.getRez_start_time(), mrRecommendRequestDTO.getRez_end_time(), Integer.valueOf(mrRecommendRequestDTO.getTot_pt_ctn()));

        // *** 2차: 회의실 주제 조회 (+1점)
        String mType = mrRecommendRequestDTO.getM_type();

        for (MrResponseVO avlMrItem : avlMr) {
            List<MrKeywordResponseVO> keywordList = avlMrItem.getMr_keyword();
            for (MrKeywordResponseVO keyword : keywordList) {
                String keywordName = keyword.getKeyword_name();
                if(mType.equals(keywordName)) {
                    avlMrItem.setPriority(avlMrItem.getPriority() + 1); // 1점 추가
                }
            }
        }

        // *** 2차: 즐겨찾기 회의실 조회 (+1000점)
        List<BmMrVO> bmMr = mapper.bmMrGetAll(mrRecommendRequestDTO.getMem_code());

        for (MrResponseVO avlMrItem : avlMr) {
            for (BmMrVO bmMrItem : bmMr) {
                if (avlMrItem.getMr_code().equals(bmMrItem.getMr_code())) {
                    avlMrItem.setPriority(avlMrItem.getPriority() + 1000);
                    break;
                }
            }
        }

        // *** 3차 : 최근 이용한 회의실 최대 5개 조회 (+100점)
        List<MrResponseVO> recentMr = mapper.recentMrGetFive(mrRecommendRequestDTO.getMem_code());

        // avlMr 리스트에 있는 회의실 중에서 recentMr 회의실 코드와 일치하는 것에 priority를 10 더하기
        for (MrResponseVO avlMrItem : avlMr) {
            for (MrResponseVO recentMrItem : recentMr) {
                if (avlMrItem.getMr_code().equals(recentMrItem.getMr_code())) {
                    avlMrItem.setPriority(avlMrItem.getPriority() + 100);
                    break;
                }
            }
        }

        // *** 4차 : 가까운 회의실 조회 (+10점)
        MemResponseVO mem = mapper.memGetOne(mrRecommendRequestDTO.getMem_code());
        String location = mem.getDeptVO().getLocation();

        for (MrResponseVO avlMrItem : avlMr) {
            String avlMrLocation = avlMrItem.getLocation(); // avlMr 아이템의 location 값
            // location 값의 일부를 잘라서 비교
            if (location.substring(0, 5).equals(avlMrLocation.substring(0, 5))) {
                avlMrItem.setPriority(avlMrItem.getPriority() + 10); // 10점 추가
            }
        }

        // 여기서 우선순위 및 기타 기준에 따라 회의실을 선택하는 로직을 추가
        avlMr.sort(Comparator.comparing(MrResponseVO::getPriority).reversed());

        // 상위 10개 추출
        List<MrResponseVO> topTenMr = avlMr.stream()
                .limit(10)
                .collect(Collectors.toList());

        topTenMr.forEach(item -> log.info(item));



        return topTenMr;
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

    @Override
    public List<BmMrVO> bmMrGetAll(String mem_code) {
        return mapper.bmMrGetAll(mem_code);
    }
}

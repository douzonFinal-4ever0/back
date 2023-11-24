package com.kosa.resq.service.car;

import com.kosa.resq.domain.dto.car.*;
import com.kosa.resq.domain.dto.common.AlertDTO;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.domain.vo.common.AlertResponseVO;
import com.kosa.resq.domain.vo.mr.ParticipantPerRezVO;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface CarUserService {
    public CarRezDTO2 carRezInfoSave(CarRezDTO carRezDTO);

    public List<CarDetailDTO2> carGetAll();
public List<AvailableCarResponseVO> carGetAll2(Date start_at,Date return_at, String mem_code);
    public CarDetailDTO2 carGetOne(String car_code);
    public List<CarLocDTO> carLocInfoGetAll(String car_rez_code);
    public List<CarRezInfoResponseVO> carRezGetAll(String mem_code);
    public List<CarRezInfoResponseVO> filterCarRezGetAll(
            String mem_code,String rez_status,int dateRange,String startAt,String endAt
    );
    public List<CarNameCodeResponseVO> searchCarGetAll();
    public CarRezResponseVO carRezDetailGetOne(String car_rez_code);
    public int carRezDelete(String car_rez_code);
    public CarRezDTO2 carRezInfoUpdate(CarRezDTO carRezDTO);
//    public CarRezDTO2 getCarRezDTO2(CarRezDTO carRezDTO);
    public OperationRequestVO operationInfoSave(OperationDTO operationDTO);
    public boolean operationInfoSave2(OperationRequestVO operationRequestVO);
    public int selectedCarUpdate(String car_code);
    public boolean receiptImgSave(MultipartFile[] images);
    public int alarmSave(AlertDTO alertDTO);
    public List<AlertResponseVO>memAlarmGetAll(List<String> mem_codes);
    public int alarmUpdate(String alert_code);
    public int announcementSave(AlertDTO alertDTO);
    public List<AlertResponseVO> announcementGetAll();
}
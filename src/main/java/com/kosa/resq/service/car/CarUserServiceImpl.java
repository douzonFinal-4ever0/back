package com.kosa.resq.service.car;


import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
import com.kosa.resq.domain.dto.car.*;
import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.domain.vo.car.*;
import com.kosa.resq.mapper.car.CarUserMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarUserServiceImpl implements CarUserService{
    @Autowired
    private CarUserMapper mapper;

    //주소를 받으면 위도 경도를 출력해주는 메소드
    public Float[] findGeoPoint(String roadFullAddr) {
        Float[] coordinate = new Float[2];

        String authorization_key = "KakaoAK e062d70fee544f0d01fc99b263e7023b";
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        String jsonString = null;

        try {
            roadFullAddr = URLEncoder.encode(roadFullAddr, "UTF-8");

            String address = apiUrl + "?query=" + roadFullAddr;

            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Authorization", authorization_key);

            BufferedReader rd = null;
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuffer docJson = new StringBuffer();

            String line;

            while ((line = rd.readLine()) != null) {
                docJson.append(line);
            }

            jsonString = docJson.toString();
            rd.close();

            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray documentsArray = jsonObject.getJSONArray("documents");
            JSONObject documentsObject = documentsArray.getJSONObject(0);

            String longtitude = documentsObject.getString("x");
            String latitude = documentsObject.getString("y");

            coordinate[0] = Float.parseFloat(longtitude);
            coordinate[1] = Float.parseFloat(latitude);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return coordinate;
    }


    @Transactional
    @Override
    public CarRezDTO2 carRezInfoSave(CarRezDTO carRezDTO) {
        //예약 번호 생성
        int carRezCode=mapper.carRezSeq();
        carRezDTO.setCar_rez_code("REZ"+carRezCode);

        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CarRezRequestVO carRezRequestVO = mapper2.map(carRezDTO,CarRezRequestVO.class);
        carRezRequestVO.setCar_code(carRezDTO.getCarDTO().getCar_code());
        carRezRequestVO.setRez_status("2");
        System.out.println(carRezRequestVO);

        CarLocRequestVO[] carLocRequestVOs = new CarLocRequestVO[3];
        String[] type = {"인수지","반납지","목적지"};
        String[] place = {carRezDTO.getReceipt_loc(),carRezDTO.getReturn_loc(),carRezDTO.getDest_loc()};
        Float[] f=findGeoPoint(carRezDTO.getReceipt_loc());
        System.out.println(place[0]);
        System.out.println(place[1]);
        System.out.println(place[2]);
        int locCode=mapper.carLocSeq();
        for(int i=0;i<carLocRequestVOs.length;i++){
            CarLocRequestVO carLocRequestVO = new CarLocRequestVO();
            locCode+=i;
            carLocRequestVO.setLoc_code("LOC"+locCode);
            System.out.println(carLocRequestVO.getLoc_code());
            carLocRequestVO.setLoc_type(type[i]);
            carLocRequestVO.setAddress(place[i]);
            carLocRequestVO.setCar_rez_code(carRezRequestVO.getCar_rez_code());
            carLocRequestVO.setMem_code(carRezRequestVO.getMem_code());
            carLocRequestVO.setCar_code(carRezRequestVO.getCar_code());
            //위도 경도
            Float[] coords =new Float[2];
            coords=findGeoPoint(place[i]);
            System.out.println(coords[0]);
            System.out.println(coords[1]);
            carLocRequestVO.setLatitude(coords[1]);
            carLocRequestVO.setLongitude(coords[0]);
            carLocRequestVOs[i]=carLocRequestVO;
        }
        System.out.println(carRezRequestVO);

        mapper.carRezSave(carRezRequestVO);
        mapper.carLocSave(carLocRequestVOs[0]);
        mapper.carLocSave(carLocRequestVOs[1]);
        mapper.carLocSave(carLocRequestVOs[2]);
        CarRezResponseVO carRezResponseVO=mapper.carRezGetOne(carRezDTO.getCar_rez_code());
        CarRezDTO2 carRezDTO2 = mapper2.map(carRezResponseVO,CarRezDTO2.class);
        carRezDTO2.setCarLoc(carLocInfoGetAll(carRezDTO.getCar_rez_code()));
        MemDTO memDTO = mapper2.map(carRezResponseVO.getMemResponseVO(),MemDTO.class);
        carRezDTO2.setMemDTO(memDTO);
        CarDTO carDTO = mapper2.map(carRezResponseVO.getCarDetailResponseVO().getCarVO(),CarDTO.class);
        carRezDTO2.setCarDTO(carDTO);
        System.out.println(carRezDTO2);
        return carRezDTO2;
    }

    @Override
    public List<CarDetailDTO2> carGetAll() {
        List<CarDetailResponseVO> carList=mapper.carGetAll();
        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        List<CarDetailDTO2> carDetailDTOList = carList.stream().map(c->mapper2.map(c,CarDetailDTO2.class)).
                collect(Collectors.toList());
        return carDetailDTOList;
    }

    @Override
    public List<AvailableCarResponseVO> carGetAll2() {
        List<AvailableCarResponseVO> carList=mapper.carGetAll2();
        return carList;
    }


    @Override
    public CarDetailDTO2 carGetOne(String car_code) {
        CarDetailResponseVO carDetailResponseVO = mapper.carGetOne(car_code);
        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CarDetailDTO2 carDetailDTO = mapper2.map(carDetailResponseVO,CarDetailDTO2.class);
        return carDetailDTO;
    }

    @Override
    public List<CarLocDTO> carLocInfoGetAll(String car_rez_code) {
        List<CarLocResponseVO> carLocList=mapper.carLocInfoGetAll(car_rez_code);
        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        List<CarLocDTO> carDetailDTOList = carLocList.stream().map(c->mapper2.map(c,CarLocDTO.class))
                .collect(Collectors.toList());
        return carDetailDTOList;
    }

    //@Transactional
    @Override
    public List<CarRezInfoResponseVO> carRezGetAll(String mem_code) {
//        List<CarRezResponseVO> carRezResponseVOList=mapper.carRezGetAll(mem_code);
//        ModelMapper mapper2 = new ModelMapper();
//        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
//        List<CarRezDTO2> carRezDTO2List = carRezResponseVOList.stream().map(c-> {
//                    CarRezDTO2 carRezDTO2 = mapper2.map(c, CarRezDTO2.class);
//                    CarDTO carDTO = mapper2.map(c.getCarVO(),CarDTO.class);
//                    CarDetailDTO carDetailDTO = mapper2.map(mapper.carGetOne(carDTO.getCar_code()),CarDetailDTO.class);
//                    carDTO.setCarDetail(carDetailDTO);
//                    carRezDTO2.setCarDTO(carDTO);
//                    MemDTO memDTO = mapper2.map(c.getMemResponseVO(),MemDTO.class);
//                    carRezDTO2.setMemDTO(memDTO);
//                    return carRezDTO2;
//                })
//                .collect(Collectors.toList());

        return mapper.carRezGetAll(mem_code);
    }

    @Override
    public List<CarRezInfoResponseVO> filterCarRezGetAll(String mem_code, String rez_status) {
        String  status;
        if(rez_status.equals("0")){
            return mapper.carRezGetAll(mem_code);
        }else{
            return mapper.filterCarRezGetAll(mem_code,rez_status);
        }
    }

    @Override
    public List<CarNameCodeResponseVO> searchCarGetAll() {
        return mapper.searchCarGetAll();
    }

    @Override
    public CarRezResponseVO carRezDetailGetOne(String car_rez_code) {
        return mapper.carRezGetOne(car_rez_code);
    }

    @Override
    public int carRezDelete(String car_rez_code) {
        return mapper.carRezDelete(car_rez_code);
    }

    @Transactional
    @Override
    public CarRezDTO2 carRezInfoUpdate(CarRezDTO carRezDTO) {
        mapper.carLocDelete(carRezDTO.getCar_rez_code());
//        System.out.println(carRezDTO);
        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CarRezRequestVO carRezRequestVO = mapper2.map(carRezDTO,CarRezRequestVO.class);
        carRezRequestVO.setCar_code(carRezDTO.getCarDTO().getCar_code());
        System.out.println(carRezRequestVO);
//        System.out.println(carRezDTO.getCar_rez_code());
        mapper.carRezUpdate(carRezRequestVO);
        //장소
//        CarLocRequestVO[] carLocRequestVOs = new CarLocRequestVO[3];
//        String[] address={carRezDTO.getReceipt_loc(),carRezDTO.getReturn_loc(),carRezDTO.getDest_loc()};
//        String[] type = {"인수지","반납지","목적지"};
//        for(int i=0;i<3;i++){
//            CarLocRequestVO carLocRequestVO = new CarLocRequestVO();
//            carLocRequestVO.setCar_rez_code(carRezDTO.getCar_rez_code());
//            carLocRequestVO.setAddress(address[i]);
//            carLocRequestVO.setLoc_type(type[i]);
//            carLocRequestVO.setCar_code(carRezDTO.getCarDTO().getCar_code());
//            Float[] coords =new Float[2];
//            coords=findGeoPoint(carLocRequestVO.getAddress());
//            carLocRequestVO.setLongitude(coords[0]);
//            carLocRequestVO.setLatitude(coords[1]);
//            carLocRequestVOs[i]=carLocRequestVO;
//        }
//        mapper.carLocUpdate(carLocRequestVOs[0]);
//        mapper.carLocUpdate(carLocRequestVOs[1]);
//        mapper.carLocUpdate(carLocRequestVOs[2]);

        CarLocRequestVO[] carLocRequestVOs = new CarLocRequestVO[3];
        String[] type = {"인수지","반납지","목적지"};
        String[] place = {carRezDTO.getReceipt_loc(),carRezDTO.getReturn_loc(),carRezDTO.getDest_loc()};
        Float[] f=findGeoPoint(carRezDTO.getReceipt_loc());
        System.out.println(place[0]);
        System.out.println(place[1]);
        System.out.println(place[2]);
        int locCode=mapper.carLocSeq();
        for(int i=0;i<carLocRequestVOs.length;i++){
            CarLocRequestVO carLocRequestVO = new CarLocRequestVO();
            locCode+=i;
            carLocRequestVO.setLoc_code("LOC"+locCode);
            System.out.println(carLocRequestVO.getLoc_code());
            carLocRequestVO.setLoc_type(type[i]);
            carLocRequestVO.setAddress(place[i]);
            carLocRequestVO.setCar_rez_code(carRezRequestVO.getCar_rez_code());
            carLocRequestVO.setMem_code(carRezRequestVO.getMem_code());
            carLocRequestVO.setCar_code(carRezRequestVO.getCar_code());
            //위도 경도
            Float[] coords =new Float[2];
            coords=findGeoPoint(place[i]);
            System.out.println(coords[0]);
            System.out.println(coords[1]);
            carLocRequestVO.setLatitude(coords[1]);
            carLocRequestVO.setLongitude(coords[0]);
            carLocRequestVOs[i]=carLocRequestVO;
            System.out.println(carLocRequestVO);
        }
        mapper.carLocSave(carLocRequestVOs[0]);
        mapper.carLocSave(carLocRequestVOs[1]);
        mapper.carLocSave(carLocRequestVOs[2]);
        CarRezResponseVO carRezResponseVO=mapper.carRezGetOne(carRezDTO.getCar_rez_code());
        CarRezDTO2 carRezDTO2 = mapper2.map(carRezResponseVO,CarRezDTO2.class);
        carRezDTO2.setCarLoc(carLocInfoGetAll(carRezDTO.getCar_rez_code()));
        MemDTO memDTO = mapper2.map(carRezResponseVO.getMemResponseVO(),MemDTO.class);
        carRezDTO2.setMemDTO(memDTO);
        CarDTO carDTO = mapper2.map(carRezResponseVO.getCarDetailResponseVO().getCarVO(),CarDTO.class);
        carRezDTO2.setCarDTO(carDTO);
        System.out.println(carRezDTO2);
        return carRezDTO2;
    }

    @Transactional
    @Override
    public OperationDTO operationInfoSave(OperationDTO operationDTO) {
        //입력 받은 후계기판을 이용해서 실제 주행거리 구하기
        operationDTO.setDistance(operationDTO.getAft_mileage()-operationDTO.getBef_mileage());
        System.out.println("service: "+ operationDTO);
        //메퍼 만들기
        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        //만약 지출이 있을 경우
        if(operationDTO.getExpenditureDTO()!=null){
            List<ExpenditureRequestVO> expenditureRequestVOList=new ArrayList<>();
            List<ExpenditureDTO> expenditureDTOList = operationDTO.getExpenditureDTO();
            for(ExpenditureDTO expenditureDTO:expenditureDTOList){
                expenditureDTO.setAccount("차량 정비");
                expenditureDTO.setMem_code(operationDTO.getMem_code());
                expenditureDTO.setStatus("미승인");
                if(expenditureDTO.getUrl()==null){
                    expenditureDTO.setUrl("");
                }
//                System.out.println("expDTO: "+expenditureDTO);
                ExpenditureRequestVO expenditureRequestVO = mapper2.map(expenditureDTO,ExpenditureRequestVO.class);
                //지출 정보 저장
                System.out.println("expVO: "+expenditureRequestVO);
                mapper.expenditureSave(expenditureRequestVO);
            }
        }

        OperationRequestVO operationRequestVO = mapper2.map(operationDTO,OperationRequestVO.class);
//        operationRequestVO.setDistance(operationDTO.getAft_mileage()-operationDTO.getBef_mileage());
        System.out.println("operationRequestVO: "+operationRequestVO);
        //운행 정보 저장
        mapper.operationSave(operationRequestVO);
        //차량 예약 정보 업데이트
        mapper.carRezCompleteUpdate(operationRequestVO.getCar_rez_code());
        CarLocResponseVO carLocResponseVO = mapper.carLocReturnGetOne(operationRequestVO.getCar_rez_code());
        CarDetailRequestVO carDetailRequestVO = new CarDetailRequestVO(
                operationRequestVO.getCar_code(),operationRequestVO.getAft_mileage(),carLocResponseVO.getLatitude(),
                carLocResponseVO.getLongitude(),carLocResponseVO.getAddress()
        );
        //차량 상세 정보 업데이트
        mapper.carDetailUpdate(carDetailRequestVO);
        return operationDTO;
    }
}
package com.kosa.resq.service.car;


import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
import com.kosa.resq.domain.dto.car.*;
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
    public CarRezDTO carRezInfoSave(CarRezDTO carRezDTO) {
        //예약 번호 생성
        int carRezCode=mapper.carRezSeq();
        carRezDTO.setCar_rez_code("REZ"+carRezCode);

        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CarRezRequestVO carRezRequestVO = mapper2.map(carRezDTO,CarRezRequestVO.class);
        carRezRequestVO.setCar_code(carRezDTO.getCarDTO().getCar_code());
        carRezRequestVO.setRez_status("확정");

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
            //System.out.println(carLocRequestVO.getLoc_code());
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
            carLocRequestVO.setLatitude(coords[0]);
            carLocRequestVO.setLongitude(coords[1]);
            carLocRequestVOs[i]=carLocRequestVO;
        }
        System.out.println(carRezRequestVO);

        mapper.carRezSave(carRezRequestVO);
        mapper.carLocSave(carLocRequestVOs[0]);
        mapper.carLocSave(carLocRequestVOs[1]);
        mapper.carLocSave(carLocRequestVOs[2]);
        return carRezDTO;
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
    public CarDetailDTO2 carGetOne(String car_code) {
        CarDetailResponseVO carDetailResponseVO = mapper.carGetOne(car_code);
        ModelMapper mapper2 = new ModelMapper();
        mapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        CarDetailDTO2 carDetailDTO = mapper2.map(carDetailResponseVO,CarDetailDTO2.class);
        return carDetailDTO;
    }
}
package com.kosa.resq.service.car;


import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.*;
import com.kosa.resq.domain.dto.car.CarLocDTO;
import com.kosa.resq.domain.dto.car.CarRezDTO;
import com.kosa.resq.domain.vo.car.CarRezRequestVO;
import com.kosa.resq.domain.vo.car.CarRezResponseVO;
import com.kosa.resq.mapper.car.CarUserMapper;
import org.json.JSONArray;
import org.json.JSONObject;
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

@Service
public class CarUserServiceImpl implements CarUserService{
    @Autowired
    private CarUserMapper mapper;

    public Float[] getJsonData(String roadFullAddr) {
        Float[] coordinate = new Float[2];

        String authorization_key = "KakaoAK ef8c0ce6769c009d6a81fecdb782518b";
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
    public CarRezDTO carRezInfoSave(CarRezDTO carRezDTO, CarLocDTO receiptLocDTO,CarLocDTO returnLocDTO,CarLocDTO destLocDTO) {
        //예약 번호 생성
        int carRezCode=mapper.carRezSeq();
        carRezDTO.setCar_rez_code("REZ"+carRezCode);
        //차량 위치 번호 생성
        receiptLocDTO.setLoc_code("LOC"+mapper.carLocSeq());
        returnLocDTO.setLoc_code("LOC"+mapper.carLocSeq());
        destLocDTO.setLoc_code("LOC"+mapper.carLocSeq());
        Float[] coords = geoCoding("대전광역시 유성구 궁동");
        System.out.println("대전광역시 유성구 궁동" + ": ");
        //위도 경도 설정
//        Float[] coords =new Float[2];
            //수령지
//        coords=findGeoPoint(receiptLocDTO.getAddress());
//        receiptLocDTO.setLatitude(coords[0]);
//        receiptLocDTO.setLongitude(coords[1]);
//        System.out.println(receiptLocDTO);
//
//            //반납지
//        coords=findGeoPoint(returnLocDTO.getAddress());
//        returnLocDTO.setLatitude(coords[0]);
//        returnLocDTO.setLongitude(coords[1]);
//            //목적지
//        coords=findGeoPoint(destLocDTO.getAddress());
//        destLocDTO.setLatitude(coords[0]);
//        destLocDTO.setLongitude(coords[1]);
        //save
//        mapper.carRezSave(carRezDTO);
//        mapper.carLocSave(receiptLocDTO);
//        mapper.carLocSave(returnLocDTO);
//        mapper.carLocSave(destLocDTO);

        return carRezDTO;
    }
}

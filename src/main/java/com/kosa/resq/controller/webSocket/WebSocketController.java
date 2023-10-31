package com.kosa.resq.controller.webSocket;

import com.kosa.resq.domain.vo.car.CarRezInfoResponseVO;
import com.kosa.resq.service.car.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@RestController
@ServerEndpoint("/websocket")
public class WebSocketController {
//
//    static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<Session>());
//
//    @Autowired
//    private CarUserService service;
//
//    @OnOpen
//    public void onOpen(Session userSession){
//        System.out.println("Open session");
//        sessionUsers.add(userSession);
//    }
//
//    @OnClose
//    public void onClose(Session userSession){
//        System.out.println("close session");
//        sessionUsers.remove(userSession);
//    }
//
//    @OnError
//    public void onError(Throwable e){
//        e.printStackTrace();
//    }
//
//    @OnMessage
//    public void onMessage(String message) throws IOException {
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        }
//    }
}

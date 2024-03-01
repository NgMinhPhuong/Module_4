package com.example.testsocket.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHandler1 extends BinaryWebSocketHandler {
    List<byte[]> luu = new ArrayList<>();
    Set<WebSocketSession> list = new HashSet<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        session.setBinaryMessageSizeLimit(200000);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        list.remove(session);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        // Xử lý dữ liệu hình ảnh nhị phân ở đây
//        byte[] imageData = message.getPayload().array();
//        luu.add(imageData);
//        System.out.println(imageData.length);
//        if(imageData.length != 19000){
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            for(byte[] el: luu) {
//                outputStream.write(el);
//            }
//            byte[] result = outputStream.toByteArray();
//            for (WebSocketSession session1 : list) {
//                BinaryMessage processedMessage = new BinaryMessage(result);
//                session1.sendMessage(processedMessage);
//            }
//            luu = new ArrayList<>();
//        }

        byte[] imageData = message.getPayload().array();
        for (WebSocketSession session1 : list) {
            BinaryMessage processedMessage = new BinaryMessage(imageData);
            session1.sendMessage(processedMessage);
        }



    }
}

package com.example.testsocket.handler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class MyHandler extends TextWebSocketHandler {
    @Getter
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
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException {
        list.add(session);
        for(WebSocketSession session1 : list){
            if(session1 == session){
                continue;
            }
            session1.sendMessage(message);
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message)  {
        byte[] imageData = message.getPayload().array();
        // Xử lý dữ liệu hình ảnh ở bước trước

        // Gửi dữ liệu hình ảnh đã xử lý cho tất cả các kết nối WebSocket
        for (WebSocketSession session1 : list) {
            if(session1 != session) {
                BinaryMessage processedMessage = new BinaryMessage(imageData);
                try {
                    session1.sendMessage(processedMessage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}

package com.example.demo.controller;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.StompSubProtocolHandler;

import java.io.IOException;
import java.security.Principal;

@RestController

public class MessageController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String receiveMessage(Message message, StompHeaderAccessor accessor) throws IOException {
        System.out.println(accessor.getFirstNativeHeader("contentType"));


        return new String((byte[]) message.getPayload());
    }

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) throws IOException {
        //cài size message tối đa
        ((StompSubProtocolHandler) event.getSource()).setMessageSizeLimit(123456);


        // Xử lý khi kết nối WebSocket được thiết lập

        System.out.println("WebSocket connection established: " + event.getMessage());
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // Xử lý khi kết nối WebSocket được thiết lập
        System.out.println("WebSocket connection close: " + event.getMessage());
    }
}



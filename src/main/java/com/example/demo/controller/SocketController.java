package com.example.demo.controller;

import com.example.demo.socket.SocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @desp Socket控制器
 */
@Controller
public class SocketController {
//
    private Session session;
    private Set<SocketController> webSocketSet = new HashSet<>();
    private Map<Session,SocketController> webSocketMap = new HashMap<>();
    private int size = 0;
    private static final Logger logger = LoggerFactory.getLogger(SocketController.class);

    @Bean//这个注解会从Spring容器拿出Bean
    public SocketHandler infoHandler() {
        return new SocketHandler();
    }
    // 服务端Spring MVC拦截该HTTP请求，将HTTP Session载入Websocket Session中，建立会话

    @RequestMapping("/login")
    public String login(HttpSession session,String username) {
        logger.info(username + "登录建立Websocket连接");
        session.setAttribute("WEBSOCKET_USERNAME", username);
        return "home";
    }

    // 模拟服务端发送消息，其中可实现消息的广发或指定对象发送
    @RequestMapping("/message")
    public String sendMessage1(String toUser) {
        double rand = Math.ceil(Math.random() * 100);
        logger.info("信息发送给"+toUser);
        infoHandler().sendMessageToUser(toUser, new TextMessage("Websocket测试消息" + rand));
        return "message";
    }


    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException, InterruptedException {
        this.session = session;
        webSocketSet.add(this);
        webSocketMap.put(session,this);
        size++;
        logger.info("连接websocket服务器 成功......当前数量:"+size);
    }

    @OnClose
    public void onClose(Session closeSession) {
        webSocketSet.remove(this);
        webSocketMap.remove(session,this);
        size--;
        logger.info("关闭连接websocket服务器 ......当前数量:"+size);
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("来自客户端的信息"+message);
        for (SocketController item : webSocketSet) {
            try {
                item.sendMessage(message,session);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public void sendMessage(String message, Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }


}
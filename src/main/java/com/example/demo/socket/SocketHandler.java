package com.example.demo.socket;

import com.example.demo.model.Msg;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;


public class SocketHandler extends TextWebSocketHandler {

    private static final ArrayList<WebSocketSession> users;//这个会出现性能问题，最好用Map来存储，key用userid
    private static Logger logger = LoggerFactory.getLogger(SocketHandler.class);

    static {
        users = new ArrayList<>();
    }

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        users.add(session);
        logger.info("连接websocket成功......当前在线用户数量:" + users.size());
        // 离线消息推送
//        TextMessage returnMessage = new TextMessage("你将收到的离线");
//        session.sendMessage(returnMessage);
    }

    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket服务连接关闭.....");
        String username = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        users.remove(session);
        logger.info("用户" + username + "已退出！ 剩余在线用户" + users.size());
    }


    /**
     * 调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(message.getPayload());
        Msg m = new Gson().fromJson(message.getPayload(), new TypeToken<Msg>() {
        }.getType());
        if (m.getFlag() == Msg.init) {
            session.getAttributes().computeIfAbsent("WEBSOCKET_USERNAME", k -> m.getFromUser());
        } else {
            super.handleTextMessage(session, message);
            logger.debug("message:" + message.getPayload());
            TextMessage returnMessage = new TextMessage(message.getPayload());
            //session.sendMessage(returnMessage);
            //sendMessageToUser("123",returnMessage);
            logger.info("来自" + m.getFromUser() + "送去" + m.getToUser() + message.getPayload());
            sendMessageToUser(m.getToUser(), returnMessage);
        }
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        logger.debug("websocket connection closed......");
        users.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName 目标用户
     * @param message 发送的消息
     */
    public void sendMessageToUser(String userName, TextMessage message) {
        for (WebSocketSession user : users) {
            for (int i = 0; i < user.getAttributes().size(); i++) {
                if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                    try {
                        if (user.isOpen()) {
                            user.sendMessage(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }

        }
    }

    /**
     * 给其他用户发送消息
     *
     * @param session
     * @param message
     */
    public void sendMessageToOtherUser(WebSocketSession session, TextMessage message) {
        for (WebSocketSession user : users) {
            if (user == session) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message 发送的消息
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
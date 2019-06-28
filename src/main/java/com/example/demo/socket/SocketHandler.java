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
        users = new ArrayList<WebSocketSession>();
    }

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
        users.add(session);
        System.out.println("connect to the websocket success......当前数量:"+users.size());
        //这块会实现自己业务，比如，当用户登录后，会把离线消息推送给用户
//        TextMessage returnMessage = new TextMessage("你将收到的离线");
//        session.sendMessage(returnMessage);
    }

    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket connection closed......");
        String username= (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        System.out.println("用户"+username+"已退出！");
        users.remove(session);
        System.out.println("剩余在线用户"+users.size());
    }


    /**
     *
     * 调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        Msg m = new Gson().fromJson(message.getPayload(), new TypeToken<Msg>(){}.getType());
        if (m.getFlag() == Msg.init) {
            session.getAttributes().computeIfAbsent("WEBSOCKET_USERNAME", k -> m.getFromUser());
        } else {
            session.getAttributes().computeIfAbsent("WEBSOCKET_USERNAME", k -> m.getFromUser());
            super.handleTextMessage(session, message);
            logger.debug("message:"+message.getPayload().toString());
            TextMessage returnMessage = new TextMessage(message.getPayload().toString());
            //session.sendMessage(returnMessage);
            //sendMessageToUser("123",returnMessage);
            sendMessageToUser(m.getToUser(),returnMessage);
        }
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){session.close();}
        logger.debug("websocket connection closed......");
        users.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
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
     * @param message
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
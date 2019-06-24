package com.example.demo.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @desp websocket激活配置
 */
@Configuration
//@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //注册处理拦截器,拦截url为socketServer的请求
        registry.addHandler(webSocketHandler(), "/socketServer").addInterceptors(new SpringWebSocketHandlerInterceptor());

        //注册SockJs的处理拦截器,拦截url为/sockjs/socketServer的请求F
        registry.addHandler(webSocketHandler(), "/sockjs/socketServer").addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }


    @Bean
    public TextWebSocketHandler webSocketHandler(){
        return new SocketHandler();
    }
    @Bean

    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();

    }
}
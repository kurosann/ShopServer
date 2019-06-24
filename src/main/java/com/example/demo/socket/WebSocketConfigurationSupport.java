package com.example.demo.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.socket.config.annotation.ServletWebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Configuration support for WebSocket request handling.
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 */
public class WebSocketConfigurationSupport {

    @Bean
    public HandlerMapping webSocketHandlerMapping() {
        ServletWebSocketHandlerRegistry registry = new ServletWebSocketHandlerRegistry();
        registerWebSocketHandlers(registry);
        return registry.getHandlerMapping();
    }

    protected void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    }

    @Bean
    public ThreadPoolTaskScheduler defaultSockJsTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("SockJS-");
        scheduler.setPoolSize(Runtime.getRuntime().availableProcessors());
        scheduler.setRemoveOnCancelPolicy(true);
        return scheduler;
    }
}
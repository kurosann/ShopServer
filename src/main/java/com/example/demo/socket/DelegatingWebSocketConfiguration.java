package com.example.demo.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.config.annotation.WebSocketConfigurationSupport;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DelegatingWebSocketConfiguration extends WebSocketConfigurationSupport {

    private final List<WebSocketConfigurer> configurers = new ArrayList<>();

    @Autowired(required = false)
    public void setConfigurers(List<WebSocketConfigurer> configurers) {
        if (!CollectionUtils.isEmpty(configurers)) {
            this.configurers.addAll(configurers);
        }
    }

    @Override
    protected void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        for (WebSocketConfigurer configurer : this.configurers) {
            configurer.registerWebSocketHandlers(registry);
        }
    }
}
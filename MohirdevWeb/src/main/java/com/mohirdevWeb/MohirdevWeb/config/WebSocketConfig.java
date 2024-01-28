package com.mohirdevWeb.MohirdevWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public WebSocketConfig(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket-connection").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config ) {
   config.enableSimpleBroker("/topic");
   config.setApplicationDestinationPrefixes("/app");
    }

    @Bean
    @ConditionalOnMissingBean
    public SimpMessagingTemplate simpMessagingTemplate() {
        return new SimpMessagingTemplate((MessageChannel) simpMessagingTemplate);
    }
}

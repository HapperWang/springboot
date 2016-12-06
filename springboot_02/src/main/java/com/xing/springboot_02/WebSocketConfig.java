package com.xing.springboot_02;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by 汪东兴 on 2016-12-4.
 */
@Configuration
@EnableWebSocketMessageBroker //通过注解开启使用STOMP协议来传输基于代理的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {// 注册STOMP协议的节点（endpoint）,并映射指定的URL
        stompEndpointRegistry.addEndpoint("/endpointXing").withSockJS(); //注册一个STOMP的endpointXing。并制定使用SockJS协议
//        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS(); //注册一个STOMP的endpointChat。并制定使用SockJS协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理（Message Broker）
        registry.enableSimpleBroker("/topic"); //广播式配置一个/topic消息代理
//        registry.enableSimpleBroker("/queue", "/topic"); //点对点式应增加消息代理
    }
}

package com.xing.springboot_02.webSocket.controller;

import com.xing.springboot_02.webSocket.model.ResponseMessage;
import com.xing.springboot_02.webSocket.model.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by 汪东兴 on 2016-12-4.
 */
@Controller()
//@RequestMapping("webSocketController")
public class WsController {

    @Autowired
    private SimpMessagingTemplate template;//通过SimpMessagingTemplate 向浏览器发送消息

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage requestMessage) throws Exception {

        Thread.sleep(500);
        return  new ResponseMessage(requestMessage.getName() + "!");
    }

    //目前不好用
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {//在Spring Mvc 中可以用Principal直接获取当前用户信息
        if(principal.getName().equals("wangdongxing")) {// 此处为硬代码，及逻辑代码，可随意更改
            //通过convertAndSendToUser向用户发送消息，参数1：接受消息的用户；参数2：浏览器订阅的地址；参数3：消息
            template.convertAndSendToUser("admin", "/queue/notifications", principal.getName() + "-send:" + msg);
        } else {
            template.convertAndSendToUser("wangdongxing", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }
}

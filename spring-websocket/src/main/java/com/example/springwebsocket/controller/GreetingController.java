package com.example.springwebsocket.controller;

import com.example.springwebsocket.model.Greeting;
import com.example.springwebsocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public Greeting greeting(Message message) throws Exception {
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }
}

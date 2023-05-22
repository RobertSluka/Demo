//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//
//@Controller
//public class MessageController {
//    @Autowired
//    SimpMessagingTemplate simpMessagingTemplate;
//
//
//    //Mapped as /app/application
//    @MessageMapping("/application")
//    @SendTo("/all/messages")
//    public Message send(final Message message) throws Exception{
//        return message;
//    }
//
//    @MessageMapping("/private")
//    public void sendToSpecificUser(@Payload org.aspectj.bridge.Message message){
////        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "specific",message);
//    }
//
//}

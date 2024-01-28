package com.mohirdevWeb.MohirdevWeb;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SentDate {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public SentDate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }
    @Scheduled(fixedDelay = 5000L)
    public void getTime(){
        Date date = new Date();
        simpMessagingTemplate.convertAndSend("/topic/date",date);

    }
}

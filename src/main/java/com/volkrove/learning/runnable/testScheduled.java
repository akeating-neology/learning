package com.volkrove.learning.runnable;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class testScheduled {

    @Scheduled(initialDelay = 20000, fixedRate = 10000)
    public void myScheduledTask(){
        System.out.println("myScheduledTask has run: " + System.currentTimeMillis());
    }
}

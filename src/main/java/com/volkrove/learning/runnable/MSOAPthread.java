package com.volkrove.learning.runnable;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

//this is all well and good. component picks up into context. presumably.
// but since nothing ever calls this from the mainthread. async anotation/task never happens
@Component
public class MSOAPthread {

    @Async
    public void someAsyncMethod() {
        try {
            Thread.sleep(30000);	// Let me sleep for 3 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("My Name " + Thread.currentThread().getName());
    }


}

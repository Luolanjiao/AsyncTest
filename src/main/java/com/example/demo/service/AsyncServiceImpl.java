package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Semaphore;

/**
 * Created by Thinkpad on 2018/11/28.
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    public static final Semaphore semaphore = new Semaphore(1);

    @Override
    @Async("asyncServiceExcutor")
    public void executeAsync() throws InterruptedException {
        String taskName = Thread.currentThread().getName();
        System.out.println(taskName + " is start");
        semaphore.acquire();
        Thread.sleep(2000);
        System.out.println(taskName + "sleeping turns to awake");
        semaphore.release();
        System.out.println(taskName + " is end");
    }

    @Async("asyncServiceExcutor")
    public void doTestAsync(){
        String taskName = Thread.currentThread().getName();
        System.out.println(taskName + " is start");
    }
}

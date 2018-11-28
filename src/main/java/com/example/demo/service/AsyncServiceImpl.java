package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Thinkpad on 2018/11/28.
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async("asyncServiceExcutor")
    public void executeAsync() throws InterruptedException {
        System.out.println("异步执行代码");
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("异步执行结束");
    }
}

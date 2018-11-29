package com.example.demo.service;

/**
 * Created by Thinkpad on 2018/11/28.
 */
public interface AsyncService {
    void executeAsync() throws InterruptedException;
    void doTestAsync();
}

package com.example.demo.controller;

import com.example.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thinkpad on 2018/11/28.
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/task")
    public String doAsyncTask() throws InterruptedException {
        asyncService.executeAsync();
        return "ok";
    }
}

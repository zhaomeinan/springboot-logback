package com.example.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {

        logger.trace("I am trace log.汉字");
        logger.debug("I am debug log.汉字");
        logger.info("I am info log.汉字");
        System.out.println("sys info");
        logger.warn("I am warn log.汉字");
        System.out.println("sys warn");
        logger.error("I am error log.汉字");
        System.out.println("sys error");

        //int i = 1/0;
        return "hello,this is a springboot demo";
    }
}

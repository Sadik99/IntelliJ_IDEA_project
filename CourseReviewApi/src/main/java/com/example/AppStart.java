package com.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class,args);
    }

    public abstract void run(ApplicationArguments args)throws Exception;
}

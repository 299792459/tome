package com.nightwind.tome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TomeApplication {


    public static void main(String[] args) {
        SpringApplication.run(TomeApplication.class, args);
    }

}

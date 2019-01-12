package com.nju.storymapping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.niu.storymapping.mapper")
public class StorymappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorymappingApplication.class, args);
    }

}


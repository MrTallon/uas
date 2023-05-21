package com.uas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uas.mapper")
public class UasApplication {

    public static void main(String[] args) {
        SpringApplication.run(UasApplication.class, args);
    }

}

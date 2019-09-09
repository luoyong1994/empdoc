package com.ynet.empdoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.ynet.empdoc.*"})
public class EmpdocApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpdocApplication.class, args);
    }

}

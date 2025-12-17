package com.fafa.fapicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.fafa.fapicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class FaPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaPictureBackendApplication.class, args);
    }

}

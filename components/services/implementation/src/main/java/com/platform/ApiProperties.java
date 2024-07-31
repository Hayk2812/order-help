package com.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.platform","com.platform.controller","com.platform.service"})
public class ApiProperties {
    public static void main(String[] args) {
        SpringApplication.run(ApiProperties.class);
    }
}

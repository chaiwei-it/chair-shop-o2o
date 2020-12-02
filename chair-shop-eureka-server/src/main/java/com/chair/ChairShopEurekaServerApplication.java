package com.chair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ChairShopEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChairShopEurekaServerApplication.class, args);
    }

}

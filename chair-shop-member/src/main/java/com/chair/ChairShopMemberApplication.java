package com.chair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 *
 * @author chaiwei
 * @since 2018年7月14日 下午4:20:29
 */
@SpringBootApplication
@EnableEurekaClient
public class ChairShopMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChairShopMemberApplication.class, args);
    }

}
package com.thoughtwand.propwand.eurekasvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PropwandEurekasvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropwandEurekasvrApplication.class, args);
    }

}

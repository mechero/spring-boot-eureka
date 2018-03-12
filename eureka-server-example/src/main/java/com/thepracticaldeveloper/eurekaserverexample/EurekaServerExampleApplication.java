package com.thepracticaldeveloper.eurekaserverexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerExampleApplication.class, args);
  }
}

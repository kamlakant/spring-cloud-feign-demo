package com.cloud.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class ServiceBob {

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private AliceClient aliceClient;

    public static void main(String[] args) {
        SpringApplication.run(ServiceBob.class, args);
    }

    @GetMapping("/generate-stuff")
    public String generateStuff() {
        return "Stuff by Bob " + serverPort;
    }

    @GetMapping("/get-stuff/alice")
    public String getAliceStuff() {
        return aliceClient.generateStuff();
    }

}

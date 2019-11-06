package com.cloud.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("alice")
public interface AliceClient {

    @GetMapping("/generate-stuff")
    public String generateStuff();
}
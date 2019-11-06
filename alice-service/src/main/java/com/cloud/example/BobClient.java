package com.cloud.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("bob")
public interface BobClient {

    @GetMapping("/generate-stuff")
    public String generateStuff();
}
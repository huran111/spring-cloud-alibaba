package com.hr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String info;

    @GetMapping(value = "/getInfo")
    public String getInfo() {
        return info;
    }

}

package com.demo.takeout.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "zidingyi.bianliang")
public class Zidingyi {
    private long a;
    private String b;
}

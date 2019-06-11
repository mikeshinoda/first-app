package com.noon.app.config;

import com.noon.app.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value="com.noon.app")
public class SpringConfig {
    @Autowired
    AppConfig appConfig;
}

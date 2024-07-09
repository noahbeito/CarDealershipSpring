package com.example.CarDealershipSpring.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}

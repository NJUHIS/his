package com.njuhis.his;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class HisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisApplication.class, args);
    }

    /***
     * 跨域訪問。
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    @PostConstruct
    void setTimeZone() {
        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        //TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

}

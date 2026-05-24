package com.example.practice.guvi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Manually re-wires the /static/ directory back into the active context
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/static/css/");
    }
}
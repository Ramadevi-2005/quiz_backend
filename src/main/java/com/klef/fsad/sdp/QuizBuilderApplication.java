package com.klef.fsad.sdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class QuizBuilderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(QuizBuilderApplication.class, args);
    }

    // ✅ Required for WAR deployment
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuizBuilderApplication.class);
    }
}

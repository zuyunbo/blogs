package com.boke.main;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.boke.common", "com.boke.config","com.boke.main","com.boke.module"})

public class BokeMainApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BokeMainApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}

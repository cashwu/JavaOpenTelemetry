package com.demo.javaopentelemetry;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaOpenTelemetryApplication {

    public static void main(String[] args) {
//        SpringApplication.run(JavaOpenTelemetryApplication.class, args);

        SpringApplication app = new SpringApplication(
                JavaOpenTelemetryApplication.class);

        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}

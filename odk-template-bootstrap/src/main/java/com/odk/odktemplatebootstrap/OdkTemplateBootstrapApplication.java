package com.odk.odktemplatebootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.odk"})
public class OdkTemplateBootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdkTemplateBootstrapApplication.class, args);
    }

}

package com.wings.dataservice;

import com.wings.dataservice.util.SecretsUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataServiceApplication {

    public static void main(String[] args) {
        SecretsUtil.initializeSecrets();
        SpringApplication.run(DataServiceApplication.class, args);
    }

}

package com.uno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
//@EnableMongoAuditing
@EnableWebMvc
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UnoGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnoGameApplication.class, args);
    }

}

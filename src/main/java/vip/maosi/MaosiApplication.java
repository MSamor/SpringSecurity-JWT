package vip.maosi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class MaosiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaosiApplication.class, args);
    }

}

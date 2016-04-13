package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Гога on 11.04.2016.
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }
}

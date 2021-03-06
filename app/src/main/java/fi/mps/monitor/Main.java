package fi.mps.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main of the spring-boot-web
 * 
 * @author msopanen
 * 
 * Keycloak example
 * https://github.com/dasniko/keycloak-springboot-demo
 *
 */
@SpringBootApplication
@RestController
public class Main {

    @RequestMapping("/foo")
    public String home() {
        return "Jou vuan!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
}

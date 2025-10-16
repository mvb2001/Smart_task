package org.real.smart_task;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartTaskApplication {

    public static void main(String[] args) {
        // Load environment variables from .env
        Dotenv dotenv = Dotenv.load();

        // Manually map .env variables to Spring Boot properties
        if (dotenv.get("SERVER_PORT") != null) {
            System.setProperty("server.port", dotenv.get("SERVER_PORT"));
        }
        if (dotenv.get("DB_URL") != null) {
            System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
        }
        if (dotenv.get("DB_USERNAME") != null) {
            System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
        }
        if (dotenv.get("DB_PASSWORD") != null) {
            System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
        }
        if (dotenv.get("JWT_SECRET") != null) {
            System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
        }
        if (dotenv.get("JWT_EXPIRATION") != null) {
            System.setProperty("JWT_EXPIRATION", dotenv.get("JWT_EXPIRATION"));
        }

        // Start the Spring Boot app
        SpringApplication.run(SmartTaskApplication.class, args);
    }
}

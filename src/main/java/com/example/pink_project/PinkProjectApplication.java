package com.example.pink_project;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication()
public class PinkProjectApplication {
    public static void main(String[] args) { SpringApplication.run(PinkProjectApplication.class, args);}
    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("romeromendonca22@gmail.com");
        contact.setName("Romero Mendonça");
        contact.setUrl("github.com/rm3d0nc4");

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Server URL in Local environment");

        License mitLicense = new License()
                .name("MIT License");

        Info info = new Info()
                .title("PINK PROJECT API")
                .contact(contact)
                .version("1.0")
                .description("This API exposes endpoints for users to manage their investment products.")
                .license(mitLicense);

        System.out.printf("Initialize OPEN API at url %s\n", localServer.getUrl());
        OpenAPI openAPI = new OpenAPI()
                .info(info)
                .servers(List.of(localServer));
        return openAPI;
    }
}

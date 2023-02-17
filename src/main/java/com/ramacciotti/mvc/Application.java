package com.ramacciotti.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        log.info("The basic principle of MVC is the division of the application into three items: ");
        log.info("1) View: User interaction layer. Responsible for the interface that will be presented, showing the model information to the user.");
        log.info("2) Controller: Layer that receives requests from the view and calls a service to serve it.");
        log.info("3) Model: Data manipulation layer. These are the entities that contain the items that will be saved in the database.");
        SpringApplication.run(Application.class, args);
    }

}

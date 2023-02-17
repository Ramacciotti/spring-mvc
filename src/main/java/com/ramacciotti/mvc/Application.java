package com.ramacciotti.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        log.info("O princípio básico do MVC é a divisão da aplicação em três camadas: ");
        log.info("1) View: Camada de interação do usuário. Responsável pela interface que será apresentada, mostrando as informações do model para o usuário.");
        log.info("2) Controller: Camada que recebe as requisições da view e chama um serviço para atendê-la.");
        log.info("3) Model:  Camada de manipulação dos dados. São as entidades que contém os itens que serão guardados no banco.");

        SpringApplication.run(Application.class, args);
    }

}

package com.example.crudsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSimpleApplication {
    //Usar esta ruta: localhost:8080/estudiantes/listar

    public static void main(String[] args) {
        SpringApplication.run(CrudSimpleApplication.class, args);
    }

}

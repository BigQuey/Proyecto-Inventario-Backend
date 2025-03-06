package com.me.invbackend;

import com.me.invbackend.model.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Date;

@SpringBootApplication
public class InventarioBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioBackendApplication.class, args);
        Date fecha = new Date(System.currentTimeMillis());
        Usuario user = new Usuario(1,"a","a","b","c", fecha);
        System.out.println(user.getId_usuario());
    }

}

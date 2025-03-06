package com.me.invbackend.controller;

import com.me.invbackend.model.dao.UsuarioDao;
import com.me.invbackend.model.entity.LoginRequest;
import com.me.invbackend.model.entity.Usuario;
import com.me.invbackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    private final UsuarioDao usuarioDao;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public HomeController(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @GetMapping("/")
    public String home() {
        return "no data";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioDao.findByEmail(loginRequest.getUsername());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("errorMessage", "Usuario no encontrado"));
        }
        System.out.println("passwordUser:" + usuario.getPassword());
        System.out.println("passwordUser:" + loginRequest.getPassword());
        boolean match = passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword());
        System.out.println("match:" + match);
        boolean band = usuarioService.login(usuario);
        if (!band) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("errorMessage", "Credenciales incorrectas"));
        }

        if(!match){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("errorMessage", "Credenciales incorrectas"));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("uid", usuario.getId_usuario());
        response.put("email", usuario.getEmail());
        response.put("displayName", usuario.getNombre_usuario());
        response.put("rol",usuario.getRol());
        response.put("fecha_creacion",usuario.getFecha_creacion());
        return ResponseEntity.ok(response);
    }

}

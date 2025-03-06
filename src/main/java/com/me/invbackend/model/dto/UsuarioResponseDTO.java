package com.me.invbackend.model.dto;

import com.me.invbackend.model.entity.Usuario;

public class UsuarioResponseDTO {
    private int id_usuario;
    private String nombre_usuario;
    private String email;
    private String rol;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id_usuario = usuario.getId_usuario();
        this.nombre_usuario = usuario.getNombre_usuario();
        this.rol = usuario.getRol();
        this.email = usuario.getEmail();
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

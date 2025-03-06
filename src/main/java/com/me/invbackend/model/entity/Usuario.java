package com.me.invbackend.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


//@Data
@ToString
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @Column(nullable = false)
    private String nombre_usuario;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "contraseña")
    private String password;
    @Column(nullable = false)
    private String rol;
    @Column(name = "fecha_creacion", updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date fecha_creacion;

    public Usuario(Integer id_usuario, String nombre_usuario, String email, String password, String rol, Date fecha_creacion) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.fecha_creacion = fecha_creacion;
    }

    public Usuario() {
    }

    public Integer getId_usuario() {
        return this.id_usuario;
    }

    public String getNombre_usuario() {
        return this.nombre_usuario;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRol() {
        return this.rol;
    }

    public Date getFecha_creacion() {
        return this.fecha_creacion;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}

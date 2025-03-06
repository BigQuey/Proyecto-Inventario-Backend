package com.me.invbackend.model.entity;


import jakarta.persistence.*;
import lombok.Builder;

@Builder

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer id_proveedor;
    private String nombre_proveedor;
    private String direccion;
    private String telefono;
    private String email;

    public Proveedor(Integer id_proveedor, String nombre_proveedor, String direccion, String telefono, String email) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Proveedor() {
    }

    public Integer getId_proveedor() {
        return this.id_proveedor;
    }

    public String getNombre_proveedor() {
        return this.nombre_proveedor;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

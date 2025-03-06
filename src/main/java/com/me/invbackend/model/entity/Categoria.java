package com.me.invbackend.model.entity;


import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id_categoria;
    private String nombre_categoria;
    private String descripcion;

    public Categoria(Integer id_categoria, String nombre_categoria, String descripcion) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion = descripcion;
    }

    public Categoria() {
    }

    public Integer getId_categoria() {
        return this.id_categoria;
    }

    public String getNombre_categoria() {
        return this.nombre_categoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

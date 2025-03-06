package com.me.invbackend.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    private String nombre_producto;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;
    private int cantidad_disponible;
    private int precio_unitario;
    @JsonInclude(JsonInclude.Include.ALWAYS)
//    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "fecha_ingreso", updatable = false, insertable = false)
    private Date fecha_ingreso;
    @ManyToOne
    @JoinColumn(name = "proveedor_id", referencedColumnName = "id_proveedor", nullable = false)
    private Proveedor proveedor;
    private String estado_producto;

    public Producto(Integer id_producto, String nombre_producto, String descripcion, Categoria categoria, int cantidad_disponible, int precio_unitario, Date fecha_ingreso, Proveedor proveedor, String estado_producto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidad_disponible = cantidad_disponible;
        this.precio_unitario = precio_unitario;
        this.fecha_ingreso = fecha_ingreso;
        this.proveedor = proveedor;
        this.estado_producto = estado_producto;
    }

    public Producto() {
    }

    public Integer getId_producto() {
        return this.id_producto;
    }

    public String getNombre_producto() {
        return this.nombre_producto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public int getCantidad_disponible() {
        return this.cantidad_disponible;
    }

    public int getPrecio_unitario() {
        return this.precio_unitario;
    }

    public Date getFecha_ingreso() {
        return this.fecha_ingreso;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public String getEstado_producto() {
        return this.estado_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }
}

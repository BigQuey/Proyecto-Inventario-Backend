package com.me.invbackend.service;

import com.me.invbackend.model.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService {
    Producto getProductoById(int id);
    Producto saveProducto(Producto producto);
    void deleteProducto(Producto producto);
    List<Producto> getAllProductos();
    Page<Producto> listarProductos(Pageable pageable);
}

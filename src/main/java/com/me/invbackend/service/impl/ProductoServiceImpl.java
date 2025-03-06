package com.me.invbackend.service.impl;

import com.me.invbackend.model.dao.ProductoDao;
import com.me.invbackend.model.entity.Producto;
import com.me.invbackend.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private ProductoDao productoDao;

    @Override
    public Producto getProductoById(int id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return List.of();
    }

    @Override
    public Page<Producto> listarProductos(Pageable pageable) {
        return  productoDao.findAll(pageable);
    }
}

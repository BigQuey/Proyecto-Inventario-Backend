package com.me.invbackend.service;

import com.me.invbackend.model.entity.Categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoriaService {
    Categoria getCategoriaById(int id);
    Categoria saveCategoria(Categoria categoria);
    void deleteCategoria(Categoria categoria);
    Page<Categoria> listarCategorias(Pageable pageable);
}

package com.me.invbackend.service.impl;

import com.me.invbackend.model.dao.CategoriaDao;
import com.me.invbackend.model.entity.Categoria;
import com.me.invbackend.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public Categoria getCategoriaById(int id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    public Page<Categoria> listarCategorias(Pageable pageable) {
        return categoriaDao.findAll(pageable);
    }
}

package com.me.invbackend.model.dao;

import com.me.invbackend.model.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Integer> {
    Page<Producto> findAll(Pageable pageable);
}

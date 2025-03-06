package com.me.invbackend.model.dao;

import com.me.invbackend.model.entity.Categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Integer> {
    Page<Categoria> findAll(Pageable pageable);
}

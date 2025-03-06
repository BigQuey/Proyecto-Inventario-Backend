package com.me.invbackend.model.dao;

import com.me.invbackend.model.entity.Proveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorDao extends JpaRepository<Proveedor, Integer> {
    Page<Proveedor> findAll(Pageable pageable);
}

package com.me.invbackend.service;

import com.me.invbackend.model.entity.Proveedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProveedorService {
    Proveedor getProveedorById(int id);
    Proveedor saveProveedor(Proveedor proveedor);
    void deleteProveedor(Proveedor proveedor);
    Page<Proveedor> listarProovedores(Pageable pageable);
}

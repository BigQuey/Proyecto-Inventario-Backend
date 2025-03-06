package com.me.invbackend.service.impl;

import com.me.invbackend.model.dao.ProveedorDao;
import com.me.invbackend.model.entity.Proveedor;
import com.me.invbackend.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements IProveedorService {
    @Autowired
    private ProveedorDao proveedorDao;

    @Override
    public Proveedor getProveedorById(int id) {
        return proveedorDao.findById(id).orElse(null);
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorDao.save(proveedor);
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
        proveedorDao.delete(proveedor);
    }

    @Override
    public Page<Proveedor> listarProovedores(Pageable pageable) {
        return proveedorDao.findAll(pageable);
    }
}

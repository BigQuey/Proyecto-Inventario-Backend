package com.me.invbackend.controller;

import com.me.invbackend.model.entity.Proveedor;
import com.me.invbackend.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ProveedorController {
    @Autowired
    private IProveedorService proveedorService;

    @PostMapping("proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor create(@RequestBody Proveedor proveedor){
        return proveedorService.saveProveedor(proveedor);
    }

    @PutMapping("proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor update(@RequestBody Proveedor proveedor){
        return proveedorService.saveProveedor(proveedor);
    }

    @GetMapping("proveedor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Proveedor findById(@PathVariable int id){
        return proveedorService.getProveedorById(id);
    }
    @DeleteMapping("proveedor/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Map<String,Object> response = new HashMap<>();
        try{
            Proveedor proveedorDelete = proveedorService.getProveedorById(id);
            proveedorService.deleteProveedor(proveedorDelete);
            return new ResponseEntity<>(proveedorDelete,HttpStatus.NO_CONTENT);
        }
        catch (DataAccessException exDt) {
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("proveedor")
    @ResponseStatus(HttpStatus.OK)
    public Page<Proveedor> listarProveedores(Pageable pageable){
        return proveedorService.listarProovedores(pageable);
    }

}

package com.me.invbackend.controller;

import com.me.invbackend.model.entity.Categoria;
import com.me.invbackend.model.entity.Producto;
import com.me.invbackend.model.entity.Proveedor;
import com.me.invbackend.service.ICategoriaService;
import com.me.invbackend.service.IProductoService;
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
@RequestMapping("/api/v1")
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @Autowired
    private ICategoriaService categoriaService;
    @Autowired
    private IProveedorService proveedorService;
    @PostMapping("producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto Create(@RequestBody Producto producto) {
        System.out.println(producto.getCategoria());
        System.out.println(producto.getCategoria().getId_categoria());
        System.out.println(producto);
        Categoria categoria = categoriaService.getCategoriaById(producto.getCategoria().getId_categoria());

        Proveedor proveedor = proveedorService.getProveedorById(producto.getProveedor().getId_proveedor());

        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);
        Producto prod = productoService.saveProducto(producto);
        return productoService.getProductoById(prod.getId_producto());
    }
    @PutMapping("producto")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Producto update(@RequestBody Producto producto) {
        Categoria categoria = categoriaService.getCategoriaById(producto.getCategoria().getId_categoria());
        Proveedor proveedor = proveedorService.getProveedorById(producto.getProveedor().getId_proveedor());

        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        productoService.saveProducto(producto);
        Producto prods = productoService.getProductoById(producto.getId_producto());
        System.out.println(prods);
        return prods;
//        return productoService.saveProducto(producto);
    }
    @GetMapping("producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Producto findById(@PathVariable int id){
        return productoService.getProductoById(id);
    }
    @DeleteMapping("producto/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        Map<String,Object> response = new HashMap<>();
        try{
            Producto productoDelete = productoService.getProductoById(id);
            productoService.deleteProducto(productoDelete);
            return new ResponseEntity<>(productoDelete,HttpStatus.NO_CONTENT);
        }
        catch (DataAccessException exDt) {
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("producto")
    @ResponseStatus(HttpStatus.OK)
    public Page<Producto> listarProductos(Pageable pageable){
        return productoService.listarProductos(pageable);
    }
}


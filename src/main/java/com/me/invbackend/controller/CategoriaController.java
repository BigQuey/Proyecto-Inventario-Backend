package com.me.invbackend.controller;

import com.me.invbackend.model.entity.Categoria;
import com.me.invbackend.service.ICategoriaService;
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
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @PostMapping("categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria Create(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }
    @PutMapping("categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria Update(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }
    @GetMapping("categoria/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria findById(@PathVariable int id) {
        return categoriaService.getCategoriaById(id);
    }
    @DeleteMapping("categoria/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Map<String,Object> response = new HashMap<>();
        try{
            Categoria categoriaDelete = categoriaService.getCategoriaById(id);
            categoriaService.deleteCategoria(categoriaDelete);
            return new ResponseEntity<>(categoriaDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt) {
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("categoria")
    public Page<Categoria> listarCategorias(Pageable pageable){
        return categoriaService.listarCategorias(pageable);
    }
}

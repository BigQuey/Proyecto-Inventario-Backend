package com.me.invbackend.service;

import com.me.invbackend.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IUsuarioService {
    Usuario addUsuario(Usuario user);
    Usuario findById(int id);
    void deleteUsuario(Usuario user);
    boolean login(Usuario user);
    List<Usuario> findAll();
    Page<Usuario> listarUsuarios(Pageable pageable);
}

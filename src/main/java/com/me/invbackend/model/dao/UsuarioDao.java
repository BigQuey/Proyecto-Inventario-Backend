package com.me.invbackend.model.dao;

import com.me.invbackend.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDao extends JpaRepository<Usuario,Integer> {
    Usuario findByEmail(String email);
    Page<Usuario> findAll(Pageable pageable);
}

package com.me.invbackend.service.impl;

import com.me.invbackend.model.dao.UsuarioDao;
import com.me.invbackend.model.entity.Usuario;
import com.me.invbackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceIml implements IUsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional
    @Override
    public Usuario addUsuario(Usuario user) {
        return usuarioDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(int id) {
        //System.out.println("usuario con el id " + id);
        //System.out.println(usuarioDao.findById(id));
        return usuarioDao.findById(id).orElse(null);
    }

    public List<Usuario> findAll(){
        return usuarioDao.findAll();
    }


    @Override
    public void deleteUsuario(Usuario user) {
        usuarioDao.delete(user);
    }

    @Override
    public boolean login(Usuario user) {
        boolean band;
        Usuario us = usuarioDao.findByEmail(user.getEmail());
        System.out.println("Usuario: " + user.getEmail());
        System.out.println("Usuario: " + user.getPassword());
        if (us == null) {
            band = false;
        }else{
            band = true;
        }
        return band;
    }

    @Override
    public Page<Usuario> listarUsuarios(Pageable pageable) {
        return usuarioDao.findAll(pageable);
    }
}

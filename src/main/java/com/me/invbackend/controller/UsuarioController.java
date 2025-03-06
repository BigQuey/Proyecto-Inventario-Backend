package com.me.invbackend.controller;

import com.me.invbackend.model.dao.UsuarioDao;
import com.me.invbackend.model.dto.UsuarioResponseDTO;
import com.me.invbackend.model.entity.Usuario;
import com.me.invbackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioDao usuarioDao;

    @PostMapping("usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario Create(@RequestBody Usuario usuario) {
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        return usuarioService.addUsuario(usuario);
    }
    @PutMapping("usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO update(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario updateUser =  usuarioService.addUsuario(usuario);
        return new UsuarioResponseDTO(updateUser);
    }
    @DeleteMapping("usuario/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String,Object> response = new HashMap<>();
        try{
            Usuario usuarioDelete = usuarioService.findById(id);
            usuarioService.deleteUsuario(usuarioDelete);
            return new ResponseEntity<>(usuarioDelete,HttpStatus.NO_CONTENT);
        }
        catch (DataAccessException exDt) {
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario findById(@PathVariable Integer id) {
        System.out.println(usuarioService.findById(id));
        return usuarioService.findById(id);
    }

    @GetMapping("usuario/actualizar-password")
    public void actualizarContraseña(){
        List<Usuario> usuarios = usuarioService.findAll(); // Obtiene todos los usuarios

        for (Usuario usuario : usuarios) {
            String hashedPassword = passwordEncoder.encode(usuario.getPassword()); // Encripta la contraseña actual
            usuario.setPassword(hashedPassword);
            usuarioDao.save(usuario); // Guarda la contraseña encriptada en la BD
        }
        System.out.println("Todas las contraseñas han sido encriptadas correctamente.");
    }
    @GetMapping("usuario")
    @ResponseStatus(HttpStatus.OK)
    public Page<Usuario> listartUsuario(Pageable pageable) {
        return usuarioService.listarUsuarios(pageable);
    }
}

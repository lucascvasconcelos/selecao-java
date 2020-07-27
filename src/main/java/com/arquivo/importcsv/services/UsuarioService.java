package com.arquivo.importcsv.services;

import com.arquivo.importcsv.models.Usuario;
import com.arquivo.importcsv.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void create (Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void delete (Long id) {
        usuarioRepository.deleteById(id);
    }

    public void update (Long id, Usuario usuario) {
        usuario.setId(id);
        usuarioRepository.save(usuario);
    }
}

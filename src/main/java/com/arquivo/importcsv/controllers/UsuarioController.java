package com.arquivo.importcsv.controllers;

import com.arquivo.importcsv.models.Usuario;
import com.arquivo.importcsv.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> index () {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> create (@RequestBody Usuario usuario) {
        usuarioService.create(usuario);

        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return new ResponseEntity<String>("deletado", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.update(id, usuario);
        return new ResponseEntity<String>("atualizado", HttpStatus.OK);
    }
}

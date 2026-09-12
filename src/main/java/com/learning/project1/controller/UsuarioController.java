package com.learning.project1.controller;


import com.learning.project1.entity.Usuario;
import com.learning.project1.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//ANOTAÇÕES:
// RequestMapping: Define o endereço base da API
// GET,PUT,DELETE,POST São as requisições HTTPs
//RequestBody: Pega os dados do Objeto que vieram de dentro do corpo da requisição
//PathVariable: Pega uma informação que veio na URL

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public  UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findUsuarios() {

        List<Usuario> usuarios = usuarioService.findUsuarios();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable Long id) {

        Optional<Usuario> usuario = usuarioService.findUsuarioById(id);

        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @PutMapping
    public ResponseEntity<Void> updateUsuario(@RequestBody Usuario usuario) {

        usuarioService.updateUsuario(usuario);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {

        usuarioService.deleteUsuario(id);

        return ResponseEntity.noContent().build();
    }
}


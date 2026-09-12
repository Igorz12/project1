package com.learning.project1.service;

import com.learning.project1.entity.Usuario;
import com.learning.project1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvarUsuario(Usuario usuario) {

        if (usuario.getId() == null || usuario.getId() == 0 ){
            throw new IllegalArgumentException("Impossível registrar. Usuário com ID incorreto.");
        }

        if (usuario.getIdade() <= 0) {
            throw new IllegalArgumentException("Impossível registrar. Usuário com Idade incorreta.");
        }

        if (usuario.getNome() == null || usuario.getNome().isBlank() ){
            throw new IllegalArgumentException("Impossível registrar. Usuário com Nome incorreto.");
        }
        usuarioRepository.salvarUsuario(usuario);
    }

    public void deleteUsuario(Long id) {
        if (id  == null || id == 0 ){
        throw new IllegalArgumentException("Impossível registrar. Usuário com ID: " + id + " incorreto.");
        }
       usuarioRepository.deleteUsuario(id);
    }

    public void updateUsuario(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0 ){
            throw new IllegalArgumentException("Impossível atualizar. Usuário com ID"
                    + usuario.getId()  + " não existe");
        }
        usuarioRepository.updateUsuario(usuario);
    }

    public List<Usuario> findUsuarios() {
        return usuarioRepository.findUsuarios();
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        if (id == null || id == 0 ){
            throw new IllegalArgumentException("Impossível registrar. Usuário com ID: " + id + " incorreto.");
        }
        return usuarioRepository.findUsuarioById(id);
    }

}

package com.learning.project1.repository;

import com.learning.project1.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void salvarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarios.removeIf(u -> Objects.equals(u.getId(), id));
    }

    public void updateUsuario(Usuario usuario) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (Objects.equals(usuarios.get(i).getId(), usuario.getId())) {
                usuarios.set(i, usuario);
                return;

            }
        }
    }

    public List<Usuario> findUsuarios() {
        return List.copyOf(usuarios);
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarios.stream().filter(usuario ->
                Objects.equals(usuario.getId(), id)).findFirst();
    }
}

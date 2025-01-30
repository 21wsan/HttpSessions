package org.wsan.apiservlet.webapp.headers.services;

import org.wsan.apiservlet.webapp.headers.models.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}

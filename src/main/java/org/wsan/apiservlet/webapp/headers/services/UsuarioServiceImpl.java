package org.wsan.apiservlet.webapp.headers.services;

import org.wsan.apiservlet.webapp.headers.models.Usuario;
import org.wsan.apiservlet.webapp.headers.repositories.UsuarioRepository;
import org.wsan.apiservlet.webapp.headers.repositories.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(Connection connection){
        this.usuarioRepository = new UsuarioRepositoryImpl(connection);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}

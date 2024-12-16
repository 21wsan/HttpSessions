package org.wsan.apiservlet.webapp.headers.services;

import org.wsan.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listar();

    Optional<Producto> porId(Long id);
}

package org.wsan.apiservlet.webapp.headers.controller;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.wsan.apiservlet.webapp.headers.models.Producto;
import org.wsan.apiservlet.webapp.headers.services.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.jsp", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Inject
    private ProductoService service;

    @Inject
    private LoginService auth;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Producto> productos = service.listar();

        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameOptional);
        req.setAttribute("title", req.getAttribute("title") + ": Listado de Productos");

        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}

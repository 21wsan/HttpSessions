package org.wsan.apiservlet.webapp.headers.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/carro/ver")
public class VerCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", req.getAttribute("title") + ": Carro de Compras");

        getServletContext().getRequestDispatcher("/carro.jsp").forward(req, resp);
    }
}

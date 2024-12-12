package org.wsan.apiservlet.webapp.headers.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.wsan.apiservlet.webapp.headers.models.Producto;
import org.wsan.apiservlet.webapp.headers.services.LoginService;
import org.wsan.apiservlet.webapp.headers.services.LoginServiceCookieImpl;
import org.wsan.apiservlet.webapp.headers.services.ProductoService;
import org.wsan.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceCookieImpl();
        Optional<String> cookieOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {


            out.println("<!DOCTYPE Html>");
            out.println("<Html>");
            out.println("    <head>");
            out.println("         <meta charset=\"UTF-8\">");
            out.println("         <title>Listado de productos</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("         <h1>Listado de productos!</h1>");
            if(cookieOptional.isPresent()) {
                out.print("<div style='color: blue;'>Hola " + cookieOptional.get() + " Bienvenido!</div>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            if(cookieOptional.isPresent()) {
                out.println("<th>precio</th>");
            }
            out.print("</tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                if(cookieOptional.isPresent()) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                }
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("    </body>");
            out.println("</Html>");
        }
    }
}

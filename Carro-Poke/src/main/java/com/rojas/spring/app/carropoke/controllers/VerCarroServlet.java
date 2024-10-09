package com.rojas.spring.app.carropoke.controllers;

import com.rojas.spring.app.carropoke.models.Carro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ver-carro")
public class VerCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener la sesión actual
        HttpSession session = req.getSession();
        Carro carro = (Carro) session.getAttribute("carro");

        // Si el carro es null, crea uno nuevo
        if (carro == null) {
            carro = new Carro();
            session.setAttribute("carro", carro);
        }

        // Ahora, redirigir a la página carro.jsp
        getServletContext().getRequestDispatcher("/carro.jsp").forward(req, resp);

    }
}

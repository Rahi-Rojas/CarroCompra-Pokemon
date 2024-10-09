package com.rojas.spring.app.carropoke.controllers;

import com.rojas.spring.app.carropoke.services.SessionService;
import com.rojas.spring.app.carropoke.services.SessionServiceimp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final String USUARIO = "admin";
    private final String PASSWORD = "12345";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("password");
        //todo: Implementamos la sesión
        SessionService service = new SessionServiceimp();
        String usuarioLogeado = service.getUsuarioDeSession(req);

        if (username != null && password != null) {
                if (username.equals(USUARIO) && password.equals(PASSWORD)) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("username", username);

                    resp.sendRedirect(req.getContextPath() + "/home.jsp");
            } else {
                req.setAttribute("error", "El usuario y contraseña no son correctos");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }else{
            req.setAttribute("error", "Los campos no pueden estas vacios");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}

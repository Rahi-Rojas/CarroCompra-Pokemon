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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionService service = new SessionServiceimp();
        String usuario = service.getUsuarioDeSession(req);

        if(usuario != null) {
            HttpSession session = req.getSession(false);
            if(session!= null) {
                session.invalidate();
            }
        }
        //Todo: Requiere una ruta y puede ser hasta del google
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}

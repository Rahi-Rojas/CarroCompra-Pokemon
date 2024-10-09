package com.rojas.spring.app.carropoke.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionServiceimp implements SessionService{

    @Override
    public String getUsuarioDeSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session!= null) {
            return (String) session.getAttribute("username");
        }
        return "";
    }
}

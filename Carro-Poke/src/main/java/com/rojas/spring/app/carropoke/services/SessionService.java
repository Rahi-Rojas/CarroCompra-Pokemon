package com.rojas.spring.app.carropoke.services;

import jakarta.servlet.http.HttpServletRequest;

public interface SessionService {
        String getUsuarioDeSession(HttpServletRequest request);
}

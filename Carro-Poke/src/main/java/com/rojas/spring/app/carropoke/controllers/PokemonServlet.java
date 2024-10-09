package com.rojas.spring.app.carropoke.controllers;

import com.rojas.spring.app.carropoke.models.Pokemon;
import com.rojas.spring.app.carropoke.services.PokemonService;
import com.rojas.spring.app.carropoke.services.PokemonServiceimp;
import com.rojas.spring.app.carropoke.services.SessionService;
import com.rojas.spring.app.carropoke.services.SessionServiceimp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pokemon")
public class PokemonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PokemonService service = new PokemonServiceimp();
        //todo: Implementamos la sesión
        SessionService sesionService = new SessionServiceimp();
        String usuario = sesionService.getUsuarioDeSession(req);

        resp.setContentType("text/html;charset=utf-8");
        try(PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <meta charset=\"UTF-8\">");
            out.println("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("   <script src=\"https://cdn.tailwindcss.com\"></script>");
            out.println("<head>");
            out.println("<title>Pokémon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista Pokemones</h1>");
            if (usuario!= null) {
                out.println("<p>Bienvenido " + usuario.toUpperCase() + "!</p>");
            } else {
                out.println("<p>Debes iniciar sesión para ver la lista de Pokémones.</p>");
            }
            out.println("       <div class=\"flex flex-wrap justify-center\">");
            out.println("       <table class=\"w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400\">");
            out.println("           <thead class=\"text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400\">");
            out.println("               <tr>");
            out.println("                   <th scope=\"col\" class=\"px-6 py-3\">Id</th>");
            out.println("                   <th scope=\"col\" class=\"px-6 py-3\">Nombre</th>");
            out.println("                   <th scope=\"col\" class=\"px-6 py-3\">Categoría</th>");
            if (usuario != null) {
                out.println("                   <th scope=\"col\" class=\"px-6 py-3\">Precio</th>");
                out.println("                   <th scope=\"col\" class=\"px-6 py-3\">Acción</th>");
            }
            out.println("               </tr>");
            out.println("           </thead>");
            out.println("           <tbody>");
            for (Pokemon p : service.listarPokemon()) {
                out.println("               <tr class=\"bg-white border-b dark:bg-gray-800 dark:border-gray-700\">");
                out.println("                   <td class=\"px-6 py-4\">" + p.getId() + "</td>");
                out.println("                   <td class=\"px-6 py-4\">" + p.getNombre() + "</td>");
                out.println("                   <td class=\"px-6 py-4\">" + p.getCategoria() + "</td>");
                if (usuario!= null) {
                    out.println("                   <td class=\"px-6 py-4\">" + p.getPrecio() + "</td>");
                    out.println("<td><a href=\"" + req.getContextPath() + "/agregar-carro?id=" + p.getId() + "\">Agregar al Carro</a></td>");
                }
                    out.println("               </tr>");
            }
            out.println("           </tbody>");
            out.println("       </table>");
            out.println("   </div>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
}

package com.rojas.spring.app.carropoke.controllers;

import com.rojas.spring.app.carropoke.models.Carro;
import com.rojas.spring.app.carropoke.models.ItemPokemon;
import com.rojas.spring.app.carropoke.models.Pokemon;
import com.rojas.spring.app.carropoke.services.PokemonService;
import com.rojas.spring.app.carropoke.services.PokemonServiceimp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        long idlong = Long.parseLong(id);

        PokemonService service = new PokemonServiceimp();
        Pokemon pokemon = service.buscarPokemonPorId(idlong);
        if (pokemon != null) {
            //todo: Obtenemos la sesión
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");
            if (carro == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            }
            //todo: verificamos si el pokemon ya existe en el carro de la sessión
            ItemPokemon itemPokemon = carro.getItemByPokemon(pokemon);
            if (itemPokemon != null) {
                //todo: Si el pokemon ya esta en el carro de la sessión
                //todo: Agregar un pokemon por es el +1
                itemPokemon.setCantidad(itemPokemon.getCantidad() + 1);
            }else {
                ItemPokemon itemPokemon1 = new ItemPokemon(pokemon, 1);
                carro.agregarItemPokemon(itemPokemon1);
            }//todo: Manzana cantidad = 1 con el click se va aumentando
        }
        resp.sendRedirect(req.getContextPath() + "/ver-carro");
    }
}

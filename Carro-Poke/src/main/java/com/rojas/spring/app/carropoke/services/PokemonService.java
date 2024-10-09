package com.rojas.spring.app.carropoke.services;

import com.rojas.spring.app.carropoke.models.Pokemon;

import java.util.List;

public interface PokemonService {
    List<Pokemon> listarPokemon();
    Pokemon buscarPokemonPorId(long id);
}

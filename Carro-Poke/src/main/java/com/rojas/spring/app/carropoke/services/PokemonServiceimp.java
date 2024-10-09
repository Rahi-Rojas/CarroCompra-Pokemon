package com.rojas.spring.app.carropoke.services;

import com.rojas.spring.app.carropoke.models.Pokemon;

import java.util.List;

public class PokemonServiceimp implements PokemonService{

    @Override
    public List<Pokemon> listarPokemon() {
            return List.of(new Pokemon(1, "Pikachu", "comun", 35),
                    new Pokemon(2, "Charmander", "comun", 50),
                    new Pokemon(3, "Squirtle", "comun", 44),
                    new Pokemon(4, "Bulbasaur", "comun", 30));
    }

    @Override
    public Pokemon buscarPokemonPorId(long id) {
        boolean encontrado = false;
        for (Pokemon pokemon : listarPokemon()) {
            if (id == pokemon.getId()) {
                encontrado = true;
                return pokemon;
            }
        }
        if (!encontrado) {
            return null;
        }
        return null;
    }
}

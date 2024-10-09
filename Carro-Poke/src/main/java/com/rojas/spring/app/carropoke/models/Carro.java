package com.rojas.spring.app.carropoke.models;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    private List<ItemPokemon> pokemonList;
    //todo: creando el carro con la lista creada
    public Carro() {
        this.pokemonList = new ArrayList<>();
    }
    //todo: Retornando la lista
    public List<ItemPokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<ItemPokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void agregarItemPokemon(ItemPokemon itemPokemon) {
        boolean encontro = false;
        for (ItemPokemon item : pokemonList) {
            if (item.getPokemon().equals(itemPokemon.getPokemon())) {
                item.setCantidad(item.getCantidad() + itemPokemon.getCantidad());
                encontro = true;
                break;
            }
        }
        if (!encontro) {
            pokemonList.add(itemPokemon);
        }
    }
    //todo: Sacando el precio total
    public double getTotal() {
        double total = 0;
        for (ItemPokemon item : pokemonList) {
            total += item.getTotalItemPrecio();
        }
        return total;
    }
    //todo: Buscando un item por pokemon
    public ItemPokemon getItemByPokemon(Pokemon pokemon) {
    for (ItemPokemon item : pokemonList) {
            if (item.getPokemon() == (pokemon)) {
                return item;
            }
        }
        return null; //Todo: Buscar item por pokemon
    }

    public List<ItemPokemon> getItemsCarro() {
        return pokemonList;
    }

}

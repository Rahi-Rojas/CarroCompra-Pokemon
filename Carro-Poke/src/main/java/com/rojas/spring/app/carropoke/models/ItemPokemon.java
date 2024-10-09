package com.rojas.spring.app.carropoke.models;

import java.util.Objects;

public class ItemPokemon {
    private Pokemon pokemon;
    private int cantidad;

    public ItemPokemon(Pokemon pokemon, int cantidad) {
        this.pokemon = pokemon;
        this.cantidad = cantidad;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalItemPrecio(){
        return pokemon.getPrecio() * cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPokemon that = (ItemPokemon) o;
        return pokemon.equals(that.pokemon);
    }
    @Override
    public int hashCode() {
        return Objects.hash(pokemon);
    }

}

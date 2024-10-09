package com.rojas.spring.app.carropoke.models;

import java.util.Objects;

public class Pokemon {
    private long id;
    private String nombre;
    private String categoria;
    private double precio;

    public Pokemon(long id, String nombre, String categoria, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;  // Compara si son la misma instancia
    if (o == null || getClass() != o.getClass()) return false;  // Verifica si la clase es la misma
    Pokemon producto = (Pokemon) o;  // Convierte el objeto para compararlo
    return id == producto.id;  // Compara los ids (tipos primitivos)
}

    @Override
    public int hashCode() {
        return Objects.hash(id);  // Genera un hash code basado en el id
    }
}

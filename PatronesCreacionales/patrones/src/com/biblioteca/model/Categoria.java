package com.biblioteca.model;

public class Categoria {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre + " - " + descripcion;
    }
}

package com.biblioteca.model;

public class Autor {
    private String nombre;
    private String apellido;
    private String nacionalidad;

    public Autor(String nombre, String apellido, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + nacionalidad + ")";
    }
}

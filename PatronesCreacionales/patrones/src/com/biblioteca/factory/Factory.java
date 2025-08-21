package com.biblioteca.factory;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;

public interface Factory {
    Object crear(String tipo);
}

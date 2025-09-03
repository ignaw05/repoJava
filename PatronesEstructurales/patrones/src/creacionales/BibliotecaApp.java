package creacionales;

import creacionales.biblioteca.db.ConexionBD;
import creacionales.biblioteca.factory.LibroFactory;
import creacionales.biblioteca.model.*;

import java.sql.Connection;
import java.sql.SQLException;

public class BibliotecaApp {
    public static void main(String[] args) throws SQLException, CloneNotSupportedException {
        // Singleton: conexión a BD
        ConexionBD conexion = ConexionBD.getInstancia();
        Connection conn = conexion.getConnection();
        System.out.println("Conexión a BD establecida: " + (conn != null));

        // Builder: crear autor, categoría y libro
        Autor autor = new Autor("Gerardo", "Magni", "Argentina");
        Categoria categoria = new Categoria("Programación", "Libros de programación");
        Libro libro = new Libro.LibroBuilder()
                .setTitulo("Java Avanzado")
                .setAutor(autor)
                .setCategoria(categoria)
                .setAnioPublicacion(2025)
                .build();
        System.out.println(libro);

        // Factory Method: crear libro según tipo
        LibroFactory factory = new LibroFactory();
        Libro novela = factory.crear("novela");
        System.out.println(novela);

        // Usuario y préstamo (Prototype)
        Usuario usuario = new Usuario("Juan", "juan@mail.com", "Estudiante");
        Prestamo prestamo1 = new Prestamo(1, usuario, libro, "2025-08-17");
        Prestamo prestamo2 = prestamo1.clone();
        System.out.println(prestamo1);
        System.out.println(prestamo2);
    }
}

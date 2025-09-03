import abstractfactory.*;
import factory.*;
import prototype.*;
import singleton.*;
import builder.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        LocalDate fecha1 = LocalDate.parse("10/08/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fecha2 = LocalDate.parse("12/09/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fecha3 = LocalDate.parse("15/10/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // SINGLETON
        System.out.println("\n--- SINGLETON ---");
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println(db1 == db2); //  Deberia devolver true por ser la misma instancia

        // FACTORY
        System.out.println("\n--- FACTORY ---");
        Libro lib1 = LogisticaLibro.crearLibro("Martin Fierro","José Hernández",20000,"Digital");
        Libro lib2 = LogisticaLibro.crearLibro("Don Quijote","Miguel de Cervantes",35000,"FISICO");

        lib1.leerDatos(); // Libros creados con el parametro "tipo"
        lib2.leerDatos();

        // BUILDER
        System.out.println("\n--- BUILDER ---");
        Usuario us1 = new Usuario.Builder()
                .setNombre("Ignaw")
                .setEmail("iw@gmail.com")
                .setTelefono("2612514127")
                .setFechaNacimiento(LocalDate.parse("09/04/2005", DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();

        Usuario us2 = new Usuario.Builder()
                .setNombre("ChuluAndino27")
                .setEmail("santinoandino@gmail.com")
                .setTelefono("2612554433")
                .setDireccion("Feliciano Gambarte 1921")
                .setFechaNacimiento(LocalDate.parse("12/09/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();

        System.out.println(us1); // Como son opcionales los atributos, no tiene direccion
        System.out.println(us2);

        // ABSTRACT FACTORY
        System.out.println("\n--- ABSTRACT FACTORY ---");
        AbstractFactory factory;

        factory = new AdminFactory(); // PARA ADMIN
        us1.setTipoUsuario(factory); // Uso el mismo usuario de arriba, pero le asigno un tipo de usuario
        us1.iniciarSesion();

        factory = new UsuarioFactory(); // PARA USER
        us2.setTipoUsuario(factory);
        us2.iniciarSesion();

        // PROTOTYPE
        System.out.println("\n--- PROTOTYPE ---");
        Prestamo pres1 = new Prestamo(lib1,us1,fecha1,fecha2);
        Prestamo pres2 = pres1.clone();
        Prestamo pres3 = pres1.clone();

        pres2.setFechaInicio(fecha2); // Cambia las fechas de pres2, pero no de pres1
        pres2.setFechaFin(fecha3);

        pres3.setLibro(lib2); // Cambia el libro de pres2, pero no de pres1

        pres1.mostrar();
        pres2.mostrar();
        pres3.mostrar();

    }
}
import Agregacion.Auto;
import Agregacion.Motor;
import Asociacion.Pasaporte;
import Asociacion.Persona;
import Bidireccional_1a1.Coche;
import Bidireccional_1a1.Patente;
import Composicion.Libro;
import DependenciaDeCreacion.GestorUsuarios;
import DependenciaDeUso.Documento;
import DependenciaDeUso.Impresora;
import RelacionUnoMuchos.Departamento;
import RelacionUnoMuchos.Empleado;

public class Main {
    public static void main(String[] args) {
        // ASOCIACION 1:1
        Persona persona1 = new Persona("Ignacio");
        Pasaporte pasaporte = new Pasaporte(46398525);
        persona1.setPasaporte(pasaporte);

        // AGREGACION 1:1
        Motor motor = new Motor("V8");
        Auto auto = new Auto("Fiat Mobi", motor);
        auto.mostrarMotor();

        // COMPOSICION 1:1
        Libro libro = new Libro(null, "Una manzana");
        libro.mostrarLibro();

        // BIDIRECCIONAL 1:1
        Coche mobi = new Coche("Fiat MOBI");
        Patente patente = new Patente("AF558MM");
        mobi.setPatente(patente);
        System.out.println(mobi.getDatos());

        // DEPENDENCIA DE USO
        Impresora hp = new Impresora("HP-553");
        Documento visa160 = new Documento("Visa J1");
        hp.imprimir(visa160);

        // DEPENDENCIA DE CREACION
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.crearYMostrar("Ignacio");

        // UNO A MUCHOS
        Departamento tioBarber = new Departamento("El Tio Barber");
        Empleado colo = new Empleado("Colo", "CEO");
        tioBarber.agregarEmpleado(colo);
        System.out.println(tioBarber.getEmpleados().getFirst().getNombre());
    }
}
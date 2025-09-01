package builder;

import abstractfactory.AbstractFactory;
import abstractfactory.InterfazUI;
import abstractfactory.MetodoEnvio;

import java.time.LocalDate;

import lombok.*;

@Builder
@Getter
@ToString
public class Usuario {
    @NonNull
    private String nombre;
    @NonNull
    private String email;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private InterfazUI interfaz;
    private MetodoEnvio metodoEnvio;

    public void setTipoUsuario(AbstractFactory factory) {
        this.interfaz = factory.crearInterfaz();
        this.metodoEnvio = factory.crearMetodoEnvio();
    }

    public void iniciarSesion(){
        System.out.println("Usuario: @"+this.getNombre());
        interfaz.mostrar();
        metodoEnvio.enviar();
    }

}

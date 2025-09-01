package prototype;

import java.time.LocalDate;
import builder.Usuario;
import factory.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Prestamo implements Cloneable { // Si no implementa CLoneable no puede clonarse
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Override  // Metodo para clonar
    public Prestamo clone(){
        try{
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Prestamo deepClone(){
        try{
            Prestamo cloned = (Prestamo)super.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void mostrar(){
        System.out.println("Prestamo de "+usuario.getNombre()+" del libro '"+libro.getTitulo()+"' desde "+fechaInicio+" hasta "+fechaFin);
    }

}


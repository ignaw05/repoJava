package factory;

import lombok.*;

@Getter
@AllArgsConstructor
public class LibroDigital implements Libro{

    private String titulo;
    private String autor;
    private int precio;

    @Override
    public void leerDatos() {
        System.out.println("El libro "+this.getTitulo()+" ($"+this.getPrecio()+") es de " + this.getAutor() + " y es digital");
    }
}

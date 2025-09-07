package proxy;
import lombok.*;

@AllArgsConstructor @Getter @Setter
public class ArchivoReal implements Archivo {
    private String nombre;
    private String contenido;

    @Override
    public void abrir(Usuario... arg) {
        System.out.println("Abriendo "+nombre+"\nContenido: "+contenido);
    }
}

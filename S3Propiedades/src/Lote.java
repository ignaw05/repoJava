import lombok.*;

@Builder
@Data // incluye getters, setters, toString, equals y hashCode
@AllArgsConstructor
@NoArgsConstructor

public class Lote {
    private int idPadron;
    private String domicilio;
    private double superficie;
    private Edificio edificioConstruido;

    public boolean isConstruible(){
        return edificioConstruido == null;
    }
}

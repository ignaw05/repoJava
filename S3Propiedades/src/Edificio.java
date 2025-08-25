import lombok.*;

@Data // incluye getters, setters, toString, equals y hashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Edificio {
    private int idEdificio;
    private String nombre;
    private double superficie;
}

import lombok.*;

@Data // incluye getters, setters, toString, equals y hashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

@ToString(exclude = "registro")
@EqualsAndHashCode(exclude = "registro")

public class Escritura {
    private int numeroEscritura;
    private Lote lote;
    private RegistroPropiedad registro;
    private String fechaEscritura;


}

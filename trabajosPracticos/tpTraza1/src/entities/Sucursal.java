package entities;
import lombok.*;

import java.time.LocalTime;

@AllArgsConstructor
@Setter @Getter @ToString
@NoArgsConstructor
@Builder

public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;
    private Empresa empresa;
    private Domicilio domicilio;

}

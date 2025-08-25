import lombok.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroPropiedad {
    private String nombrePropiedad;
    private static int nextNumeroEscritura = 0;

    @Builder.Default //IMPORTANTE PARA INCICIALIZAR LAS COLLECIONES
    private List<Escritura> escrituras = new ArrayList<>();


    public void registrarLote(Lote lote, String fechaEscritura) {
        nextNumeroEscritura++;

        Escritura escritura = new Escritura(nextNumeroEscritura, lote, this, fechaEscritura);
        escrituras.add(escritura);
        System.out.println("Added Escritura Nro " + escritura.getNumeroEscritura());
    }

    public void construirEdificio(Lote lote, Edificio edificio) {
            if (lote.isConstruible()) {
                lote.setEdificioConstruido(edificio);
                System.out.println(edificio.getNombre() + " construida en el lote " + lote.getIdPadron());
            } else {
                System.out.println("No se puede construir " + edificio.getNombre() + " en el lote " + lote.getIdPadron() + " ya hay algo ahi!");
            }
    }

    public List<Escritura> getEscrituras() {
        System.out.println("Estoy en escrituras");
        System.out.println(escrituras);
        return Collections.unmodifiableList(escrituras);
    }


}

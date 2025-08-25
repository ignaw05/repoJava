public class Main {
    public static void main(String[] args) {

        Lote lote1 = Lote.builder()
                .domicilio("EmilioCivit2002")
                .idPadron(1)
                .superficie(550)
                .build();

        Lote lote2 = Lote.builder()
                .domicilio("EmilioCivit350")
                .idPadron(2)
                .superficie(500)
                .build();

        RegistroPropiedad registro1 = RegistroPropiedad.builder()
                .nombrePropiedad("Maipu")
                .build();

        Edificio edificio1 = Edificio.builder().nombre("Empire State").superficie(500).build();
        Edificio edificio2 = Edificio.builder().nombre("Torres Gemelas").superficie(550).build();

        registro1.registrarLote(lote1,"25/06/2025");
        registro1.construirEdificio(lote1,edificio1);
        registro1.construirEdificio(lote1,edificio2);

        registro1.registrarLote(lote2,"11/09/2010");
        registro1.construirEdificio(lote2,edificio2);

        registro1.getEscrituras();


    }
}
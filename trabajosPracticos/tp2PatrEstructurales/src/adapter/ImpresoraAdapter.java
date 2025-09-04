package adapter;

public class ImpresoraAdapter implements Impresora {
    private ImpresoraTexto impresoraTexto;

    public ImpresoraAdapter() {
        this.impresoraTexto = new ImpresoraTexto();
    }

    @Override
    public void imprimir(String fileType, String fileName) {
        try {
            if (fileType.equalsIgnoreCase("txt")) {
                impresoraTexto.imprimirTxt(fileName);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("Ingrese un formato valido");
        }

    }
}


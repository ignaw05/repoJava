package adapter;

public class ImpresoraPDF implements Impresora{
    private ImpresoraAdapter impresoraAdapter;
    @Override
    public void imprimir(String fileType, String fileName) {
        if (fileType.equalsIgnoreCase("pdf")){
            System.out.println("Imprimiendo archivo PDF: "+ fileName);
        } else {
            impresoraAdapter = new ImpresoraAdapter();
            impresoraAdapter.imprimir(fileType,fileName);
        }
    }
}

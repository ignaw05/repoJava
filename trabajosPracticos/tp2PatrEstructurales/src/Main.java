import adapter.ImpresoraPDF;

public class Main {
    public static void main(String[] args) {
        ImpresoraPDF impresora = new ImpresoraPDF();

        impresora.imprimir("pdf","my_file.pdf");
        impresora.imprimir("txt","mi_archivo.txt");
        impresora.imprimir("docx","mi_tp2.docx");
        impresora.imprimir("mp4","mi_tp2.mp4");
    }
}
package estructurales.composite;

public class CompositeMain {
    public static void main(String[] args) {
        //Con este patrón, los archivos y carpetas se manejan con la misma interfaz (FileSystemItem),
        // aunque internamente se comporten distinto.

        FileSystemItem archivo1 = new File("Documento.txt");
        FileSystemItem archivo2 = new File("Foto.png");
        FileSystemItem archivo3 = new File("Video.mp4");

        Folder carpeta1 = new Folder("Mis Documentos");
        carpeta1.addItem(archivo1);
        carpeta1.addItem(archivo2);

        FileSystemItem carpetaUTN = new Folder("carpetaUTN");

        Folder carpeta2 = new Folder("Multimedia");
        carpeta2.addItem(archivo3);
        carpeta2.addItem(carpeta1); // una carpeta dentro de otra
        carpeta2.addItem(carpetaUTN);

        carpeta2.show("");
    }
}

package DependenciaDeUso;

public class Impresora {
    private String modelo;

    public Impresora(String modelo) {
        this.modelo = modelo;
    }

    public void imprimir(Documento doc){
        System.out.println("Imprimiendo en "+modelo+": "+doc.getContenido());
    }
}

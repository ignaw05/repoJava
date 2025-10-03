package entities;

import java.time.LocalDateTime;

public class Venta {
    private static long id = 1;
    private LocalDateTime fecha;
    private double monto;
    private String codigoArt;
    private String cuitComprador;
    private boolean facturada = false;

    public Venta(double monto) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        id += 1;
    }

    public void setCuitComprador(String cuitComprador) {
        this.cuitComprador = verificarNotNull(cuitComprador);
    }

    public void setCodigoArt(String codigoArt) {
        this.codigoArt = verificarNotNull(codigoArt);
    }

    public void facturar(){
        if (cuitComprador == null){
            throw new NotNullException("Ingrese cuitComprador antes de facturar");
        } else if (codigoArt == null){
            throw new NotNullException("Ingrese codigoArt antes de facturar");
        } else {
            this.facturada = true;
        }
    }

    public String verificarNotNull(String parametro){
        if (parametro == null){
            throw new NotNullException("No puede ingresar null");
        } else return parametro;

    }

    public boolean isFacturada() {
        return facturada;
    }
}

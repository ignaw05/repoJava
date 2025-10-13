package org.jcr.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double idPersona;

    @Column(name = "nombre")
    private String nombrePersona;

    @Column(name = "edad")
    private int edadPersona;

    @ManyToOne
    @JoinColumn(name = "sucursal_id") // clave foránea en tabla sucursal
    private Sucursal sucursal;

    public double getIdPersona() {
        return idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}

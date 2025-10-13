package org.jcr.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private double idSucursal;

    @Column(name = "Nombre")
    private String nombre;

    @OneToMany(mappedBy = "sucursal")
    private List<Persona> trabajadores = new ArrayList<>();

    public double getIdSucursal() {
        return idSucursal;
    }
    public void addTrabajador(Persona trabajador) {
        if (!trabajadores.contains(trabajador)){
            trabajadores.add(trabajador);
            trabajador.setSucursal(this);
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Persona> getTrabajadores() {
        return trabajadores;
    }
}

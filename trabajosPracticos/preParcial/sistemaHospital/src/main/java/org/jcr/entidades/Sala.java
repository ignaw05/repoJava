package org.jcr.entidades;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String numero;

    @Column(nullable = false, length = 100)
    private String tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Cita> citas = new ArrayList<>();

    public Sala(String numero, String tipo, Departamento departamento) {
        this.numero = validarString(numero, "El número de sala no puede ser nulo ni vacío");
        this.tipo = validarString(tipo, "El tipo de sala no puede ser nulo ni vacío");
        this.departamento = Objects.requireNonNull(departamento, "El departamento no puede ser nulo");
    }

    public void addCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }

    private String validarString(String valor, String mensajeError) {
        Objects.requireNonNull(valor, mensajeError);
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }
}

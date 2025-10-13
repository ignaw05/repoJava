package org.jcr.entidades;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Paciente extends Persona implements Serializable {

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "historiaClinica_id", unique = true)
    private HistoriaClinica historiaClinica;

    private String telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Cita> citas = new ArrayList<>();

    protected Paciente(PacienteBuilder<?, ?> builder) {
        super(builder);
        this.telefono = validarString(builder.telefono, "El teléfono no puede estar vacío");
        this.direccion = validarString(builder.direccion, "La dirección no puede estar vacía");
        this.historiaClinica = new HistoriaClinica(this);
    }

    public void setHospital(Hospital hospital) {
        if (!Objects.equals(this.hospital, hospital)) {
            if (this.hospital != null) {
                this.hospital.getPacientes().remove(this);
            }
            this.hospital = hospital;
            if (hospital != null) {
                hospital.getPacientes().add(this);
            }
        }
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

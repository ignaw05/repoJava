package org.jcr.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private EspecialidadMedica especialidad;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder.Default
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medico> medicos = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sala> salas = new ArrayList<>();

    // Métodos personalizados
    public void setHospital(Hospital hospital) {
        if (!Objects.equals(this.hospital, hospital)) {
            if (this.hospital != null) {
                this.hospital.getDepartamentos().remove(this);
            }
            this.hospital = hospital;
            if (hospital != null && !hospital.getDepartamentos().contains(this)) {
                hospital.agregarDepartamento(this);
            }
        }
    }

    public void agregarMedico(Medico medico) {
        Objects.requireNonNull(medico, "El médico no puede ser nulo");
        if (!medico.getEspecialidad().equals(this.especialidad)) {
            throw new IllegalArgumentException("Especialidad incompatible entre médico y departamento");
        }
        if (!medicos.contains(medico)) {
            medicos.add(medico);
            medico.setDepartamento(this);
        }
    }

    public Sala crearSala(String numero, String tipo) {
        Sala sala = new Sala(numero, tipo, this);
        salas.add(sala);
        return sala;
    }

    private String validarString(String valor, String mensajeError) {
        Objects.requireNonNull(valor, mensajeError);
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }

    public Sala getSalaPorNumero(String numero) {
        return salas.stream()
                .filter(s -> s.getNumero().equals(numero))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Sala no encontrada: " + numero));
    }

}

package org.jcr.entidades;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Getter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Medico extends Persona implements Serializable {

    @Embedded
    private  Matricula matricula;

    @Enumerated(EnumType.STRING)
    private  EspecialidadMedica especialidad;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Cita> citas;

    protected Medico(MedicoBuilder<?, ?> builder) {
        super(builder);
        this.matricula = builder.matricula;
        this.especialidad = builder.especialidad;
        this.departamento = builder.departamento;
        this.citas = builder.citas != null ? builder.citas : new ArrayList<>();
    }


    public void setDepartamento(Departamento departamento) {
        if (this.departamento != departamento) {
            if (this.departamento != null) {
                this.departamento.getMedicos().remove(this);
            }
            this.departamento = departamento;
            if (departamento != null) {
                departamento.getMedicos().add(this);
            }
        }
    }

    public void addCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);
    }
}

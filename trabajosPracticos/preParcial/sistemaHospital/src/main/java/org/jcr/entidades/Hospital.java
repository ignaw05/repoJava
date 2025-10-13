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
import lombok.Getter;
import lombok.ToString;


@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Hospital implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private String direccion;
	private String telefono;

	@Builder.Default
	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Departamento> departamentos = new ArrayList<>();

	@Builder.Default
	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
	private  List<Paciente> pacientes = new ArrayList<>();

	public Hospital(String nombre, String direccion, String telefono) {
		this.nombre = validarString(nombre, "El nombre del hospital no puede ser nulo ni vacío");
		this.direccion = validarString(direccion, "La dirección no puede ser nula ni vacía");
		this.telefono = validarString(telefono, "El teléfono no puede ser nulo ni vacío");
	}

	public void agregarDepartamento(Departamento departamento) {
		if (departamento != null && !departamentos.contains(departamento)) {
			departamentos.add(departamento);
			departamento.setHospital(this);
		}
	}

	public void agregarPaciente(Paciente paciente) {
		if (paciente != null && !pacientes.contains(paciente)) {
			pacientes.add(paciente);
			paciente.setHospital(this);
		}
	}

	public List<Departamento> getDepartamentos() {
		return Collections.unmodifiableList(departamentos);
	}


	private String validarString(String valor, String mensajeError) {
		Objects.requireNonNull(valor, mensajeError);
		if (valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensajeError);
		}
		return valor;
	}
}

package org.jcr.entidades;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HistoriaClinica implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String numeroHistoria;

	@OneToOne
	@JoinColumn(name = "paciente_id", unique = true)
	private Paciente paciente;

	@Column(nullable = false)
	private LocalDateTime fechaCreacion;

	@ElementCollection
	@CollectionTable(name = "diagnosticos", joinColumns = @JoinColumn(name = "historia_id"))
	@Column(length = 500)
	private final List<String> diagnosticos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "tratamientos", joinColumns = @JoinColumn(name = "historia_id"))
	@Column(length = 500)
	private final List<String> tratamientos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "alergias", joinColumns = @JoinColumn(name = "historia_id"))
	@Column(length = 200)
	private final List<String> alergias = new ArrayList<>();

	public HistoriaClinica(Paciente paciente) {
		this.paciente = Objects.requireNonNull(paciente, "El paciente no puede ser nulo");
		this.fechaCreacion = LocalDateTime.now();
		this.numeroHistoria = generarNumeroHistoria();
	}

	private String generarNumeroHistoria() {
		return "HC-" + paciente.getDni() + "-" + System.currentTimeMillis();
	}

	public void agregarDiagnostico(String diagnostico) {
		if (diagnostico != null && !diagnostico.trim().isEmpty()) {
			diagnosticos.add(diagnostico);
		}
	}

	public void agregarTratamiento(String tratamiento) {
		if (tratamiento != null && !tratamiento.trim().isEmpty()) {
			tratamientos.add(tratamiento);
		}
	}

	public void agregarAlergia(String alergia) {
		if (alergia != null && !alergia.trim().isEmpty()) {
			alergias.add(alergia);
		}
	}

	public List<String> getDiagnosticos() {
		return Collections.unmodifiableList(diagnosticos);
	}

	public List<String> getTratamientos() {
		return Collections.unmodifiableList(tratamientos);
	}

	public List<String> getAlergias() {
		return Collections.unmodifiableList(alergias);
	}
}

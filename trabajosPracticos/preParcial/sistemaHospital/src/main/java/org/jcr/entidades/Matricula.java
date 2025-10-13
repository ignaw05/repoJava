package org.jcr.entidades;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Matricula implements Serializable {

	private String numero;

	public Matricula(String numero) {
		this.numero = validarMatricula(numero);
	}

	private String validarMatricula(String numero) {
		Objects.requireNonNull(numero, "El número de matrícula no puede ser nulo");
		if (!numero.matches("MP-\\d{4,6}")) {
			throw new IllegalArgumentException("Formato de matrícula inválido. Debe ser como MP-12345");
		}
		return numero;
	}
}

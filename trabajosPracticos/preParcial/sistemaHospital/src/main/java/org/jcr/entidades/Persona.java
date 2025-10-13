package org.jcr.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.AccessLevel;

import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long id;
    protected  String nombre;
    protected  String apellido;
    protected  LocalDate fechaNacimiento;
    protected  String dni;
    @Enumerated(EnumType.STRING)
    protected TipoSangre tipoSangre;

    protected Persona(String nombre, String apellido, LocalDate fechaNacimiento, String dni, TipoSangre tipoSangre) {
        this.nombre = validarString(nombre, "El nombre no puede ser vacío");
        this.apellido = validarString(apellido, "El apellido no puede ser vacío");
        this.fechaNacimiento = Objects.requireNonNull(fechaNacimiento, "La fecha no puede ser nula");
        this.dni = validarDni(dni);
        this.tipoSangre = tipoSangre;
    }

    public void setDni(String dni) {
        this.dni = validarDni(dni);
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    private String validarString(String valor, String mensajeError) {
        Objects.requireNonNull(valor, mensajeError);
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }

    private String validarDni(String dni) {
        Objects.requireNonNull(dni, "El DNI no puede ser nulo");
        if (!dni.matches("\\d{7,8}")) {
            throw new IllegalArgumentException("El DNI debe tener 7 u 8 dígitos");
        }
        return dni;
    }

}

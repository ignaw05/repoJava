package main.java.builder;

import java.time.LocalDate;


public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;

    public Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    public static class Builder{ // Clase que va a funcionar como el constructor, definiendo los set
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private LocalDate fechaNacimiento;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Usuario build(){
            return new Usuario(this);
        }
    }

    @Override
    public String toString() {
        return "Usuario[nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento+"]";
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}

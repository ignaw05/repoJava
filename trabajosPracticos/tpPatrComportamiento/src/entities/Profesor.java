package entities;

import chainOfResponsibility.Handler;
import chainOfResponsibility.Solicitud;
import mediator.ChatMediator;
import mediator.Usuario;

public class Profesor extends Handler {
    private String nombre;
    private Curso curso;
    private Usuario usuario;

    public Profesor(String nombre, Curso curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    protected boolean procesar(Solicitud solicitud){
        if (solicitud.getNivel() <= 2) {
            System.out.println("Profesor resolviendo "+solicitud.getProblema());
            return true;
        }
        return false;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public Curso getCurso() {
        return curso;
    }


}

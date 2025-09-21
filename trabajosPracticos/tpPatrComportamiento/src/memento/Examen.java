package memento;

import entities.Curso;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    private String respuestas = "";
    private String preguntas;
    private Curso curso;

    public String getPreguntas() {
        return preguntas;
    }

    public Curso getCurso() {
        return curso;
    }

    public Examen(Curso curso, String preguntas) {
        this.preguntas = preguntas;
        this.curso = curso;
    }

    public void agregarRespuesta(String respuesta) {
        respuestas += respuesta;
    }

    public Memento save(){
        return new Memento(respuestas);
    }

    public void restore(Memento memento){
        respuestas = memento.getEstado();
    }

    public String getRespuestas() {
        return respuestas;
    }
}

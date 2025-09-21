package entities;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Curso implements Subject {
    private String nombre;
    private String horario;
    private List<Observer> alumnos = new ArrayList<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public void inscribir() {
        System.out.println("Inscribiendo en "+nombre);
    }
    public void abandonar() {
        System.out.println("Abandonando "+nombre);
    }
    public void certificado() {
        System.out.println("Solicitando certificado de "+nombre);
    }

    @Override
    public void addObserver(Observer o) {
        alumnos.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        alumnos.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o:alumnos) {
            o.update(horario,this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
        notifyObservers();
    }
}

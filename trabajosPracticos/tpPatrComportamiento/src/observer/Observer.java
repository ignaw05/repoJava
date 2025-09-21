package observer;

import entities.Curso;

public interface Observer {
    void update(String msg, Curso curso);
}

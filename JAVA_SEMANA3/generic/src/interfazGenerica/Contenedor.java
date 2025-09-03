package interfazGenerica;

interface Contenedor<T> {
    void agregar(T elemento);
    T obtener();
}

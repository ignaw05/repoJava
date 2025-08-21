package singleton;

class SingletonDCL {
    // La instancia se declara volatile para asegurar la visibilidad entre hilos
    private static volatile SingletonDCL instance;
    private String value;

    private SingletonDCL(String value) {
        this.value = value;
        System.out.println("Instancia SingletonDCL creada con valor: " + value);
    }

    public static SingletonDCL getInstance(String value) {
        if (instance == null) { // Primera comprobación sin bloqueo
            synchronized (SingletonDCL.class) {
                if (instance == null) { // Segunda comprobación dentro del bloqueo
                    instance = new SingletonDCL(value);
                }
            }
        }
        return instance;
    }

    public String getValue() {
        return value;
    }
}


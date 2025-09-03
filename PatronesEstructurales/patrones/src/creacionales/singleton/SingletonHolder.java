package creacionales.singleton;


class SingletonHolder {
    private String value;

    private SingletonHolder(String value) {
        this.value = value;
        System.out.println("Instancia SingletonHolder creada con valor: " + value);
    }

    // Clase estática anidada: la instancia se crea solo al acceder por primera vez
    private static class Holder {
        private static final SingletonHolder INSTANCE = new SingletonHolder("ValorInicial");
    }

    public static SingletonHolder getInstance() {
        return Holder.INSTANCE;
    }

    public String getValue() {
        return value;
    }
}


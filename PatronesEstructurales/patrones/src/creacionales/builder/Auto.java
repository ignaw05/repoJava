package creacionales.builder;

// Clase Auto
public class Auto {
    private final String marca;
    private final String modelo;
    private final String motor;
    private final String color;
    private final boolean aireAcondicionado;
    private final boolean gps;

    // Constructor privado: solo accesible desde el Builder
    private Auto(Builder builder) {
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.motor = builder.motor;
        this.color = builder.color;
        this.aireAcondicionado = builder.aireAcondicionado;
        this.gps = builder.gps;
    }

    // Clase estática Builder
    public static class Builder {
        private final String marca;   // obligatorios
        private final String modelo;
        private String motor = "1.6"; // valor por defecto
        private String color = "Blanco";
        private boolean aireAcondicionado = false;
        private boolean gps = false;

        public Builder(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
        }

        public Builder setMotor(String motor) {
            this.motor = motor;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setAireAcondicionado(boolean aireAcondicionado) {
            this.aireAcondicionado = aireAcondicionado;
            return this;
        }

        public Builder setGps(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Auto build() {
            return new Auto(this);
        }
    }

    @Override
    public String toString() {
        return "Auto [marca=" + marca + ", modelo=" + modelo +
                ", motor=" + motor + ", color=" + color +
                ", aireAcondicionado=" + aireAcondicionado +
                ", gps=" + gps + "]";
    }
}

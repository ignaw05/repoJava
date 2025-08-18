package Agregacion;

public class Auto {
    private String modelo;
    private Motor motor;

    public Auto(String modelo, Motor motor) {
        this.modelo = modelo;
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void mostrarMotor(){
        if (motor != null){
        System.out.println("El auto " + modelo + " tiene un motor: "+ motor.getMarca());}
        else {
            System.out.println("No tiene motor cumpa");
        }
    }
}

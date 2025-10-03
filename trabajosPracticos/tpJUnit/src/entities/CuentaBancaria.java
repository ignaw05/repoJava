package entities;

public class CuentaBancaria {
    private String numeroCuenta;
    private String propietario;
    private float saldoTotal = 0;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, String propietario) {
        this.numeroCuenta = numeroCuenta;
        this.propietario = propietario;
    }

    public float addSaldo(float dinero) {
        this.saldoTotal += dinero;
        return saldoTotal;
    }

    public float removeSaldo(float dinero) throws CuentaBancariaException {
        if (dinero>this.saldoTotal){
            throw new CuentaBancariaException("No puede retirar mas del dinero disponible");
        } else {
            this.saldoTotal -= dinero;
            return saldoTotal;
        }
    }

    public float getSaldoTotal() {
        return saldoTotal;
    }
}

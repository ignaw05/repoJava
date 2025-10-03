package test;
import entities.CuentaBancaria;
import entities.CuentaBancariaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class testCuentaBancaria {
    private CuentaBancaria cuentaBancaria;

    @BeforeEach
    public void setUp(){
        this.cuentaBancaria = new CuentaBancaria();
    }

    @AfterEach
    public void clean(){
        this.cuentaBancaria = null;
    }

    @Test
    public void testDepositar() {
        cuentaBancaria.addSaldo(100F);
        float saldo = cuentaBancaria.addSaldo(50F);
        Assertions.assertEquals(150F, saldo);
    }

    @Test
    public void testRetirar() throws Exception {
        cuentaBancaria.addSaldo(200F);
        cuentaBancaria.removeSaldo(20F);
        float saldo = cuentaBancaria.removeSaldo(30F);
        Assertions.assertEquals(150F, saldo);

        Assertions.assertThrows(CuentaBancariaException.class, () -> {
            cuentaBancaria.removeSaldo(250F);
        });
    }

    @Test
    public void flujoCompleto(){
        CuentaBancaria cuenta = new CuentaBancaria("100","Ignacion");
        cuenta.addSaldo(100F);
        float saldo = cuenta.removeSaldo(75F);

        Assertions.assertEquals(25F,saldo);
    }
}

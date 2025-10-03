package test;
import entities.NotNullException;
import entities.Venta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testVenta {
    private Venta venta;

    @BeforeEach
    public void setUp(){
    this.venta = new Venta(2000);
    }

    @AfterEach
    public void reiniciar(){
        this.venta = null;
    }

    @Test
    public void testCreacionVenta(){
        venta.setCodigoArt("Art133");

        Assertions.assertThrows(NotNullException.class, () -> {
            venta.setCuitComprador(null);
        });
        // Deberia lanzar NotNullException porque quiere cargar null en el cuit


    }

    @Test
    public void testFacturar(){
        venta.setCuitComprador("20463985252");

        Assertions.assertThrows(NotNullException.class, () -> {
            venta.facturar();
        });

        // Deberia lanzar NotNullException porque hay null en el codigoArt

        venta.setCodigoArt("Art123");
        venta.facturar();

        Assertions.assertEquals(true,venta.isFacturada());
    }
}

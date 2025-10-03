package test;
import entities.ConversorTemperatura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class testConversorTemperatura {
    private ConversorTemperatura conversorTemperatura;

    @BeforeEach
    public void setUp(){
        this.conversorTemperatura = new ConversorTemperatura();
    }


    @Test
    public void testConvertirAFahrenheit(){
        float fahren = conversorTemperatura.convertirAFahreheit(20F);

        Assertions.assertEquals(68F,fahren);
    }

    @Test
    public void testConvertirACelcius(){
        float celcius = conversorTemperatura.convertirACelcius(20F);

        Assertions.assertEquals(-6.67F,celcius);
    }

}

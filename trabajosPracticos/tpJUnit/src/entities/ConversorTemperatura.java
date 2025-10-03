package entities;

import static java.lang.Math.round;

public class ConversorTemperatura {

    public ConversorTemperatura() {
    }

    public float convertirAFahreheit(float tempCelcius){
        float fahren = (tempCelcius * 9/5) + 32;
        return (float) round(fahren * 100) /100;
    }

    public float convertirACelcius(float tempFahrenheit){
        float celcius = (tempFahrenheit - 32)* 5/9;
        return (float) round(celcius * 100) /100;
    }
}

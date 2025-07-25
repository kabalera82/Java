package Tema04_01Metodos;

public class Ejercicio24_Geometria {
    /**
     * Calcula el volumen de un cilindro.
     * Tanto el radio como la altura se deben proporcionar en las
     * mismas unidades para que el resultado sea congruente.
     *
     * @param radio  radio del cilindro
     * @param altura altura del cilindro
     * @return volumen del cilindro
     */

    public static double volumenCilindro(double radio, double altura) {
        return Math.PI * radio * radio * altura;
    }

    public static double longitudCircunferencia(double radio) {
        return 2 * Math.PI * radio;
    }
}

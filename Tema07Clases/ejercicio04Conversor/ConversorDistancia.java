package Tema07Clases.ejercicio04Conversor;

public class ConversorDistancia {

    public double millasAMetros(double millas) {
        double metros;
        metros = millas * 1852;
        return metros;
    }

    public double millasAKilometros(double millas) {
        double km;
        km = millas * 1.852;
        return km;
    }
}

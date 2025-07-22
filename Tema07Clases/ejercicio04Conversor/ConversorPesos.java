package Tema07Clases.ejercicio04Conversor;

public class ConversorPesos {
    // Atributo
    private double gramos = 0;

    // Constructor
    public ConversorPesos(double cantidad, String unidad) {
        unidad = unidad.toLowerCase(); // Convertimos a minúsculas para evitar errores

        if (unidad.equals("gr")) gramos = cantidad;
        if (unidad.equals("kg")) gramos = cantidad * 1000;
        if (unidad.equals("lb")) gramos = cantidad / 0.0022;
        if (unidad.equals("oz")) gramos = cantidad / 0.0353;
    }

    public double getLibras() {
        return gramos * 0.002205;
    }

    public double getOnzas() {
        return gramos * 0.035274;
    }

    public double getPeso() {
        return gramos / 1000;
    }

    public double getGramos() {
        return gramos;
    }
}

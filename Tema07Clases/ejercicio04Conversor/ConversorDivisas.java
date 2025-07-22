package Tema07Clases.ejercicio04Conversor;

public class ConversorDivisas {

    /*
     * - Escribe dos métodos llamados librasToEuros() y eurosToLibras().
     * - La clase constará con dos constructores para establecer el tipo de cambio.
     * - Tipo de cambio inicial: 0.85
     */

    // Atributo
    private double tipoCambio;

    // Constructor sin parámetros (tipo de cambio por defecto)
    public ConversorDivisas() {
        tipoCambio = 0.85;
    }

    // Constructor con parámetro
    public ConversorDivisas(double tc) {
        tipoCambio = tc;
    }

    // Método para convertir libras a euros
    public double librasToEuros(double libras) {
        return libras * tipoCambio;
    }

    // Método para convertir euros a libras
    public double eurosToLibras(double euros) {
        return euros / tipoCambio;
    }

    // Getter
    public double getTipoCambio() {
        return tipoCambio;
    }

    // Setter
    public void setTipoCambio(double tc) {
        tipoCambio = tc;
    }


}

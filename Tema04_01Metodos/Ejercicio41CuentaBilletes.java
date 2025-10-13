package Tema04_01Metodos;

/**
 * Ejercicio 41
 * Realizar un programa en Java que,
 * dada una cantidad entera en euros,
 * muestre la descomposición en billetes y monedas
 */

public class Ejercicio41CuentaBilletes {

    /** Creamos un Array donde incorporamos todas las monedas en forma de su valor */
    private static int [] TIPO_MONEDA = {500, 200, 100, 50, 20, 10, 5, 2, 1};

    /**
     *  Método principal: inicia el proceso de descomposición para una cantidad dada.
     *
     * @param args no necesarios
     */
    public static void main (String [] args){

       int cantidad = 2958;

        descomponer(cantidad, 0);
    }

    /**
     * Descompone recursivamente la cantidad mostrando cuántos billetes/monedas
     * de cada denominación se necesitan.
     *
     * @param cantidad cantidad restante a descomponer
     * @param indice   posición actual en el array de TIPO_MONEDA
     */

    static void descomponer (int cantidad, int indice) {
        // Caso base
        if (cantidad <= 0 || indice >= TIPO_MONEDA.length) {
            return;
        }

        int valor = TIPO_MONEDA[indice];
        int num = cantidad / valor;

        if(num > 0){
            String tipo = valor >= 5 ? "Billetes" : "Monedas";
            System.out.println(tipo + " de " + valor + ": " + num);
        }

        descomponer (cantidad % valor, indice + 1);
    }



}

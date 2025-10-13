package Tema11Colecciones.VueltaEfectivo;

/**
 * Programa que descompone una cantidad de dinero en billetes y monedas
 * utilizando recursión directa en lugar de bucles.
 */
public class Main {

    /** Array de denominaciones de mayor a menor. */
    private static final int[] DENOMINACIONES = {500, 200, 100, 50, 20, 10, 5, 2, 1};

    /**
     * Método principal: inicia el proceso recursivo para la cantidad dada.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        int cantidad = 999;
        descomponer(cantidad, 0);
    }

    /**
     * Descompone recursivamente la cantidad mostrando cuántos billetes/monedas
     * de cada denominación se necesitan.
     *
     * @param cantidad cantidad restante a descomponer
     * @param indice   posición actual en el array de denominaciones
     */
    static void descomponer(int cantidad, int indice) {
        // Caso base: si no queda cantidad o no quedan denominaciones, terminamos
        if (cantidad <= 0 || indice >= DENOMINACIONES.length) {
            return;
        }

        int valor = DENOMINACIONES[indice];
        int numero = cantidad / valor;

        if (numero > 0) {
            String tipo = valor >= 5 ? "Billetes" : "Monedas";
            System.out.println(tipo + " de " + valor + ": " + numero);
        }

        // Llamada recursiva directa → avanza a la siguiente denominación
        descomponer(cantidad % valor, indice + 1);
    }
}



}

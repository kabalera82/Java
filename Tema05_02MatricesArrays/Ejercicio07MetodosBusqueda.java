package Tema05_02MatricesArrays;

public class Ejercicio07MétodosBusqueda {

    public static void main(String[] args) {
        /**
         * Busqueda lineal - Secuencial * * * * *
         * Busqueda Binaria * * * * * * * * * * *
         * Busqueda por interpolación ***********
         * Busqueda Fibonacci *******************
         * Busqueda Exponencial *****************
         * Busqueda de salto ********************
         * Busqueda de KMP (Knuth-Morris-Pratt) *
         * API de colecciones de Java ***********
         * - Busqueda Ternaria 
         * - Busqueda de Boyer-Moore
         * - Busqueda de Rabin-Karp
         * - Busqueda de Aho-Corasick
         * - Busqueda de KMP (Knuth-Morris-Pratt)
         * - Busqueda de Z-algorithm
         * - Busqueda de Búsqueda de cadena de caracteres
         */

        // Metodo de búsqueda lineal o Secuencial
        int[] matriz = {5, 2, 3, 1, 4, 6};

        int resultado = busquedaSecuencial(matriz, 100);
        String resultadoMultiple = busquedaSecuencialMultiple(matriz, 100);

        if (resultado != -1) {
            System.out.println("El número se encuentra en el índice: " + resultado);
        } else {
            System.out.println("El número no se encuentra en la matriz.");
        }

        System.out.println("Índices encontrados (búsqueda múltiple): " + resultadoMultiple);
    }

    // Vamos a devolver el index del elemento buscado
    public static int busquedaSecuencial(int[] matriz, int numeroBuscar) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == numeroBuscar) {
                return i;
            }
        }
        return -1; // Si no se encuentra el elemento, se devuelve -1
    }

    // Búsqueda Secuencial Múltiple
    public static String busquedaSecuencialMultiple(int[] matriz, int numeroBuscar) {
        String posiciones = "";

        // Bucle para recorrer la matriz de principio a fin
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] == numeroBuscar) {
                // Si encontramos el numero, devolvemos su posición, el indice
                posiciones += i + " ";
            }
        }
        if (posiciones.equals("")) {
            return "-1"; // Si no encuentra, devuelve un -1
        }
        return posiciones.trim();
    }
}
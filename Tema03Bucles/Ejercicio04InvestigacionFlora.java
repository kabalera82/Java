package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio04InvestigacionFlora {

    public static void main(String[] args) {
        /*
         * Un centro de investigación de la flora urbana necesita una aplicación que muestre cuál es el árbol más alto.
         * Para ello se introducirá por teclado la altura (en centímetros) de cada árbol
         * (terminando la introducción de datos cuando se utilice −1 como altura).
         * Los árboles se identifican mediante etiquetas con números únicos correlativos, comenzando en 0.
         * Diseñar una aplicación que resuelva el problema planteado.
         *
         * SOLUCIÓN:
         * Introducimos la altura de cada árbol dentro de un bucle y guardaremos la mayor y el
         * número de etiqueta del árbol al que corresponde.
         * En la búsqueda del máximo (o mínimo) se nos plantea un problema: con qué valor
         * inicializamos el máximo. Hemos de inicializar el máximo con un valor menor o
         * igual que todos los valores con los que trabajaremos.
         * máximo es -2. Si inicializamos arbitrariamente máximo=0, como 0 es mayor que
         * cualquier valor del conjunto, el algoritmo dirá que el máximo es 0 (error).
         * En este caso, al trabajar con alturas (positivas), podemos inicializar sin
         * problema a 0 (es menor que cualquier positivo). Sin embargo, en el caso
         * general, la mejor opción es inicializar el máximo al primer valor leído.
         */

        Scanner sc = new Scanner(System.in);
        int altura, etiqueta = 0, alturaArbolMasAlto = -1, etiquetaArbolMasAlto = -1;

        System.out.println("Introduzca la altura del árbol (introduzca -1 para terminar): ");
        altura = sc.nextInt();

        while (altura != -1) {
            if (altura > alturaArbolMasAlto) {
                alturaArbolMasAlto = altura;
                etiquetaArbolMasAlto = etiqueta;
            }
            etiqueta++;

            System.out.println("Introduzca la altura del árbol (introduzca -1 para terminar): ");
            altura = sc.nextInt();
        }

        if (etiquetaArbolMasAlto == -1) {
            System.out.println("No se ha introducido ninguna altura.");
        } else {
            System.out.println("El árbol más alto es el número " + etiquetaArbolMasAlto + " con una altura de " + alturaArbolMasAlto + " cm.");
        }

        // Cerrar el escáner
        sc.close();
    }
}

package Tema05_02MatricesArrays;

public class Ejercicio06OrdenacionSeleccion {

    public static void main(String[] args) {

        int[] matriz = {5, 2, 3, 1, 4, 6};

        System.out.println("\nMatriz original:");
        for (int num : matriz) {
            System.out.print(num + " ");
        }
        System.out.println("");

        ordenacionSeleccion(matriz);

        System.out.println("\nMatriz ordenada:");
        for (int num : matriz) {
            System.out.print(num + " ");
        }
        System.out.println("");

    }

    public static void ordenacionSeleccion(int[] matriz) {
        //Primer bucle va desde el primer elemento hasta el penultimo
        for (int i = 0; i < matriz.length - 1; i++) {
            //segundo bucle para comparar los valores
            // Se usa para buscar el menor elemento del resto de la matriz
            for (int j = i; j < matriz.length; j++) {
                //Empieza en i + 1 para poder obtener el valor de la derecha
                if (matriz[i] > matriz[j]) {
                    //Si el elemento actual es menor que el elmento anterior
                    //se guarda dentro de auxiliar el elemento mas pequeño
                    int aux = matriz[i];

                    //finalmente intercambiamos los valores de sitio
                    matriz[i] = matriz[j];
                    matriz[j] = aux;
                }
            }
        }
    }

}

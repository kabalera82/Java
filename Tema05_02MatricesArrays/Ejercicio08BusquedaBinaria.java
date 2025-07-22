package Tema05_02MatricesArrays;

public class Ejercicio08BusquedaBinaria {

    public static void main(String[] args) {
        //La matriz debe estar ordenada para que la búsqueda binaria funcione correctamente
        //Si la matriz no está ordenada, primero debes ordenarla
        int[] matriz = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numeroBuscar = 9;

        int resultado = busquedaBinaria(matriz, numeroBuscar);

        if (resultado != -1) {
            System.out.println("El número se encuentra en el índice: " + resultado);
        } else {
            System.out.println("El número no se encuentra en la matriz.");
        }
    }

    public static int busquedaBinaria(int[] matriz, int numeroBuscar) {
        // Variable de inicio el primer elemento
        int inicio = 0;
        // Variable del fin
        int fin = matriz.length - 1;

        while (inicio <= fin) {
            //Primero debemos calcular el medio de la matriz
            int medio = (inicio + fin) / 2;

            // Comprobamos si el elemento medio es el que buscamos
            if (matriz[medio] == numeroBuscar) {
                return medio; // Elemento encontrado
            }

            // Si el elemento medio es menor que el buscado, buscamos en la mitad fin
            if (matriz[medio] < numeroBuscar) {
                inicio = medio + 1;
            } else { // Si es mayor, buscamos en la mitad inicio
                fin = medio - 1;
            }
        }

        return -1; // Elemento no encontrado
    }

}

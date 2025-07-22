package Tema04Metodos;

public class Ejercicio09FuncionRecursiva {
    // Una funcion recursiva es una función que se llama a sí misma
    // Vamos a mandar imprimir los numero del 5 al 1

    // Funcion recursiva
    static void funcionRecursiva(int numero) {
        // Caso Base
        if (numero == 0) {
            System.out.println(" Fin de la recursión");
            return; // Termina la recursión
        } else {
            // Llamada recursiva
            System.out.print(" " + numero);
            // Se tiene que llamar a la función con el número decrementado para ser
            // recursiva
            funcionRecursiva(numero - 1);
        }
    }

    static void funcionRecursiva2(int numero) {
        if (numero == 0) {
            System.out.println(" Fin de la recursion");
            return;// Termina la recursion. return termina la ejecución de la función.
        } else {
            funcionRecursiva2(numero - 1); // Llamada recursiva
            System.out.print(" " + numero);
        }
    }

    public static void main(String[] args) {
        funcionRecursiva(5);
        funcionRecursiva2(5);
    }

}

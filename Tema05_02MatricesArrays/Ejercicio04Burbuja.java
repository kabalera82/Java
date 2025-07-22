package Tema05_02MatricesArrays;

/**
 * Tema 5, 2 [Tablas]
 * <p>
 * Ejercicio 04: [Método de Ordenación de la Burbuja]
 *
 * @author kabadev
 */
public class Ejercicio04Burbuja {
    /*
    Compara el primer elemento con el segundo.
    Si el primero es mayor que el segundo, los intercambia.
    Continúa comparando todos los pares consecutivos.
    Al final de cada pasada, el mayor elemento "flota" al final (como una burbuja 🫧).
    Se repite el proceso reduciendo el número de elementos a comparar, hasta que no se necesita ningún cambio.
     */

    public static void main(String[] args) {

        int[] matriz = {26, 50, 7, 9, 15, 27};
        System.out.println("Matriz sin ordenar: ");
        for (int elemento : matriz) {
            System.out.print(" " + elemento);
        }
        burbuja(matriz);
        System.out.println("\n" + "Matriz Ordenada: ");
        for (int elemento : matriz) {
            System.out.print(" " + elemento);
        }
    }

    //static no necesita de un objeto si le pasamos la matriz le pasamos el objeto(apuntan al mismo punto de memoria)
    public static void burbuja(int[] matriz) {

        int aux = 0;
        String pasada = "";
        //primer bucle para las pasadas
        for (int i = 0; i < matriz.length; i++) {
            //segundo bucle para comparar los valores
            //(valor / posicion actual) con el valor o la posicion de la derecha

            //empezamos j = 1; para que este en el lugar de la derecha
            for (int j = 1; j < matriz.length; j++) {
                //Hacemos la comparacion, si el de la derecha es menor que el actual (j-1)
                if (matriz[j] < matriz[j - 1]) {
                    aux = matriz[j];//le asignamos el valor de la derecha a la auxiliar
                    matriz[j] = matriz[j - 1]; // asignamos el valor de la izquierda a la posicion de la derecha
                    matriz[j - 1] = aux;//le asignamos el valor de la auxiliar al de la izquierda

                    //Opcional
                    System.out.println("matriz[j] = " + matriz[j] + " matriz[j-1] = " + matriz[j - 1] + " aux = " + aux);
                    for (int k = 0; k < matriz.length; k++) {
                        pasada += " " + matriz[k];
                    }
                    System.out.println("Matriz matriz = {" + pasada + "}");
                    pasada = "";
                }
            }
        }
    }
}

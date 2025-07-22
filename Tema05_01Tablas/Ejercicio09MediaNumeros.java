package Tema05_01Tablas;

import java.util.Scanner;

public class Ejercicio09MediaNumeros {

    /**
     * Introduce por teclado un número n;
     * a continuación, solicita al usuario que teclee n números.
     * Realiza la media de los números positivos,
     * la media de los negativos y cuenta el número de ceros introducidos
     */


    public static void main(String[] args) {
        System.out.println("Introduce un número n");
        //ACTIVAMOS EL SCANNER
        Scanner sc = new Scanner(System.in);
        //PEDIMOS AL USUARIO QUE INSERTE UN NUMERO
        int n = sc.nextInt();
        //SOLICITA AL USUARIO QUE INTRODUZCA N NÚMEROS;
        int[] numeros = leerNumeros(sc, n);

        //LLAMADA METODO QUE CALCULA Y MUESTRA RESULTADOS
        calcularYMostrarResultados(numeros);
    }

    public static int[] leerNumeros(Scanner scan, int n) {
        //CREA UN ARRAY PARA INTRODUCIR LOS NUMEROS INTRODUCIDOS POR EL USUARIO
        int[] numeros = new int[n];
        System.out.println("Introduce " + n + "números");
        //LEEMOS LOS NÚMEROS
        for (int i = 0; i < n; i++) {
            numeros[i] = scan.nextInt(); //BUCLE PARA LEER Y ALMACENAR EN EL ARRAY
        }
        return numeros;//DEVOLVEMOS EL ARRAY NÚMEROS;
    }

    public static void calcularYMostrarResultados(int[] numeros) {
        //INICIALIZAR VARIABLES PARA ALMACENAR LA SUMA DE POSITIVOS, NEGATIVOS Y EL CONTENIDO DE CEROS.
        int sumaPositivos = 0;
        int sumaNegativos = 0;
        int cuentaPositivos = 0;
        int cuentaNegativos = 0;
        int cuentaCeros = 0;
        //RECORREMOS EL ARRAY NUMEROS
        for (int numero : numeros) {
            if (numero > 0) {//SI EL NÚMERO ES POSITIVO
                sumaPositivos += numero;//SUMARLO A LA SUMA DE POSITIVOS
                cuentaPositivos++;// AUMENTAR EL CONTADOR DE POSITIVOS
            } else if (numero < 0) { //SI EL NUMERO ES NEGATIVO
                sumaNegativos -= numero;//SUMARLO A LA SUMA DE NEGATIVOS
                cuentaNegativos--;//AUMENTAR EL CONTADOR DE NEGATIVOS
            } else {//ENTONCES SI EL NUMERO ES CERO
                cuentaCeros++;
            }
        }
        //CALCULAR MEDIA NUMEROS POSITIVOS
        double mediaPositivos = (cuentaPositivos > 0) ? (double) sumaPositivos / cuentaPositivos : 0;
        //CALCULAR MEDIA NÚMEROS NEGATIVOS
        double mediaNegativos = (cuentaNegativos < 0) ? (double) sumaNegativos / cuentaNegativos : 0;

        // Mostrar los resultados
        System.out.println("Media de los números positivos: " + mediaPositivos);
        System.out.println("Media de los números negativos: " + mediaNegativos);
        System.out.println("Número de ceros introducidos: " + cuentaCeros);
    }

}

package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio22MaximoRecursivo {

    /**
     * Esciribir una función que calcule de forma recursiva el máximo común
     * divisor de dos números. Para ello sabemos: mcd(a, b= ={ mcd(a- b, b) si a
     * >=b mcd(a, b) = { mcd(a, b-a) si b> a mcd(a, b) = { a si b = 0 mcd(a, b)
     * = { b si a = 0
     * <p>
     * Para calcular el maximo común divisor usaremos, según el caso, una de las
     * dos llamadas recursivas; mcd(a, b) = mcd(a-b, b) si a>=b mcd(a, b) =
     * mcd(a, b-a) si b>a
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, resultado;
        System.out.println("Introduce el primer número: ");
        a = sc.nextInt();
        System.out.println("Introduce el segundo número: ");
        b = sc.nextInt();
        resultado = mcd(a, b);
        System.out.println("El mcd es " + resultado);
    }

    //Funcion recursiva
    static int mcd(int a, int b) {
        int resultado;
        if (a == 0) { //Primer caso base
            resultado = b;
        } else if (b == 0) {
            resultado = a; //Segundo caso base
        } else {
            int min = a <= b ? a : b;//Calculamos el minimo de a y b
            int max = a <= b ? b : a;//Calculamos el maximo de a y b
            resultado = mcd(min, max - min);// llamada recursiva
        }

        return resultado;
    }
}

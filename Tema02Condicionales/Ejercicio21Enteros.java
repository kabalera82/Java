package Tema02Condicionales;

public class Ejercicio21Enteros {

    /*
     * Escribe una aplicación que pida al usuario dos números enteros y
     * muestre: true, si am-bos números son distintos entre sí
     * o alguno de ellos es cero; y false en caso contrario.
     */
    public static void main(String[] args) {
        // Crear una instancia de Scanner para leer la entrada del usuario
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Solicitar al usuario que introduzca el primer número
        System.out.println("Introduce el primer número (a): ");
        int a = sc.nextInt();

        // Solicitar al usuario que introduzca el segundo número
        System.out.println("Introduce el segundo número (b): ");
        int b = sc.nextInt();

        // Comparar los dos números y mostrar el resultado
        boolean resultado = (a != b) || (a == 0) || (b == 0);
        System.out.println(resultado);

        // Cerrar el Scanner
        sc.close();
    }
}

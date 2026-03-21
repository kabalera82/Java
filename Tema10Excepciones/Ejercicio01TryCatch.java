/**
 * Ejercicio 01 - try-catch basico
 *
 * Demuestra como capturar excepciones en tiempo de ejecucion.
 * Sin el try-catch, cada uno de estos bloques lanzaria un error
 * y terminaria el programa abruptamente.
 */
public class Ejercicio01TryCatch {

    public static void main(String[] args) {

        // 1. Division por cero
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico: " + e.getMessage());
        }

        // 2. Acceso fuera de rango en un array
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera de rango: " + e.getMessage());
        }

        // 3. Conversion de String a int con valor invalido
        try {
            int numero = Integer.parseInt("abc");
            System.out.println("Numero: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Formato invalido: " + e.getMessage());
        }

        // 4. NullPointerException
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("Referencia nula — el objeto no existe");
        }

        System.out.println("El programa continua tras capturar las excepciones.");
    }
}

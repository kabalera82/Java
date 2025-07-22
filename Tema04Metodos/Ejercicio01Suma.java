package Tema04Metodos;

public class Ejercicio01Suma {

    // Método para sumar dos números
    static int sumar(int a, int b) {
        int resultado = a + b;
        return resultado; // Devuelve el resultado de la suma
    }

    // Método main para ejecutar la clase (punto de entrada)
    public static void main(String[] args) {

        int arg1 = 5; // Primer argumento
        int arg2 = 3; // Segundo argumento

        var resultado = arg1 + arg2;
        // Llamada al método sumar con los argumentos definidos
        resultado = sumar(arg1, arg2); // Llama al método sumar con argumentos
        System.out.println("La suma es: " + resultado); // Imprime el resultado

        resultado = sumar(10, 20);
        System.out.println(resultado);
    }


}

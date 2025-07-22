package Tema04Metodos;

public class Ejercicio18Calculadora {

    /**
     * Diseñar la función calculadora(), a la que se le pasan dos números reales (operandos)
     * y qué operación se desea realizar con ellos. Las operaciones disponibles son:
     * sumar, restar, multiplicar o dividir.
     * Estas se especifican mediante un número:
     * 1 para la suma, 2 para la resta, 3 para la multiplicación y 4 para la división.
     * La función devolverá el resultado de la operación mediante un número real.
     */

    public static void main(String[] args) {
        for (int operacion = 1; operacion <= 4; operacion++) {//bucle para las operaciones
            double resultado = calculadora(3.0, 4.0, operacion); // operamos con 3.0 y 4.0

            System.out.println(resultado);
        }
    }

    //realiza la operación indicada:
    //1- suma
    //2- resta
    //3- multiplicación
    //4- división

    static double calculadora(double a, double b, int operación) {
        double result; // resultado de la operación
        return switch (operación) {
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> a / b;
            default -> {
                System.out.println("Operación no válida");
                yield 0.0; // operación no válida
            }
        };
    }
}

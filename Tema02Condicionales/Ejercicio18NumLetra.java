package Tema02Condicionales;

public class Ejercicio18NumLetra {

    public static void main(String[] args) {
        /*
        Escribe un programa que solicite al usuario un número comprendido entre 1 y 99.
        El programa debe mostrarlo con letras,
        */

        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            System.out.println("Introduce un número entre 1 y 99: ");
            int numero = sc.nextInt();
            String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
            String[] decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
            if (numero < 10) {
                System.out.println(unidades[numero]);
            } else if (numero < 20) {
                switch (numero) {
                    case 10 -> System.out.println("diez");
                    case 11 -> System.out.println("once");
                    case 12 -> System.out.println("doce");
                    case 13 -> System.out.println("trece");
                    case 14 -> System.out.println("catorce");
                    case 15 -> System.out.println("quince");
                    default -> System.out.println("dieci" + unidades[numero - 10]);
                }
            } else {
                int decena = numero / 10;
                int unidad = numero % 10;
                if (unidad == 0) {
                    System.out.println(decenas[decena]);
                } else {
                    System.out.println(decenas[decena] + " y " + unidades[unidad]);
                }
            }
        }
    }
}

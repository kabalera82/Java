package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio23Calificaciones {

    /*
     * Solicita al usuario su nombre, edad y promedio de calificaciones.
     * Usa System.out.println para confirmar cada dato ingresado por el usuario en la consola.
     * Realiza un cálculo sencillo usando la edad y el promedio (por ejemplo,
     * incrementa la edad en 5 años y calcula la mitad del promedio de calificaciones).
     * Solicita un valor boolean para confirmar si el usuario está satisfecho con el resultado de los cálculos.
     * Muestra un mensaje de despedida personalizado en función de si el usuario está satisfecho o no.
     */
    public static void main(String[] args) {
        // DECLARAMOS LAS VARIABLES.
        String nombre = null, motivo;
        int edad = 0, opcion;
        double nota1 = 0, nota2 = 0, nota3 = 0, nota4 = 0, promedio;
        boolean correcto = true;
        Scanner sc = new Scanner(System.in);

        // PEDIMOS AL USUARIO QUE INTRODUZCA LOS DATOS.
        //COMPROBAMOS QUE LOS DATOS INTRODUCIDOS SON CORRECTOS.
        do {
            System.out.println("Introduzca el Nombre: ");

            if (sc.hasNextInt() && sc.hasNextDouble() && sc.hasNextFloat() && sc.hasNextByte() && sc.hasNextShort() && sc.hasNextLong()) {
                System.out.println("Error de tipo. Introduce un nombre válido.");
                sc.next();
                correcto = false;
            } else if (sc.hasNextLine()) { // Corregido else(sc.hasNextLine() a else if (sc.hasNextLine())
                nombre = sc.nextLine();
                if (!nombre.trim().isEmpty() && nombre.length() > 0) {
                    correcto = true;
                } else {
                    System.out.println("Error de nombre.");
                    correcto = false;
                    sc.next();
                }
            }

            // CAPTURAMOS LA EDAD CON EL ESCÁNER QUE SIGUE ACTIVO.
            do {
                System.out.println("Introduzca su edad");
                if (sc.hasNextInt()) {
                    edad = sc.nextInt();
                    if (edad >= 1) {
                        correcto = true;
                    } else {
                        System.out.println("Error de Edad");
                        correcto = false;
                    }
                } else {
                    System.out.println("Error de tipo. Introduce un número válido");
                    sc.next();
                    correcto = false;
                }
            } while (!correcto);
            //CAPTURAMOS LAS NOTAS Y COMPROBAMOS QUE SE UN DATO VÁLIDO
            do {
                System.out.println("Introduzca su 1ª nota");
                if (sc.hasNextDouble()) {
                    nota1 = sc.nextDouble();
                    if (nota1 > 0 && nota1 < 100) {
                        correcto = true;
                    } else {
                        System.out.println("Error de Nota");
                        correcto = false;
                    }
                } else {
                    System.out.println("Error de tipo. Introduce un número válido");
                    sc.next();
                    correcto = false;
                }
            } while (!correcto);
            do {
                System.out.println("Introduzca su 2ª nota");
                if (sc.hasNextDouble()) {
                    nota2 = sc.nextDouble();
                    if (nota2 > 0 && nota2 < 100) {
                        correcto = true;
                    } else {
                        System.out.println("Error de Nota");
                        correcto = false;
                    }
                } else {
                    System.out.println("Error de tipo. Introduce un número válido");
                    sc.next();
                    correcto = false;
                }
            } while (!correcto);
            do {
                System.out.println("Introduzca su 3ª nota");
                if (sc.hasNextDouble()) {
                    nota3 = sc.nextDouble();
                    if (nota3 > 0 && nota3 < 100) {
                        correcto = true;
                    } else {
                        System.out.println("Error de Nota");
                        correcto = false;
                    }
                } else {
                    System.out.println("Error de tipo. Introduce un número válido");
                    sc.next();
                    correcto = false;
                }
            } while (!correcto);
            do {
                System.out.println("Introduzca su 4ª nota");
                if (sc.hasNextDouble()) {
                    nota4 = sc.nextDouble();
                    if (nota4 > 0 && nota4 < 100) {
                        correcto = true;
                    } else {
                        System.out.println("Error de Nota");
                        correcto = false;
                    }
                } else {
                    System.out.println("Error de tipo. Introduce un número válido");
                    sc.next();
                    correcto = false;
                }
            } while (!correcto);

            promedio = (nota1 + nota2 + nota3 + nota4) / 4;
            // MOSTRAMOS LOS DATOS INTRODUCIDOS.
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad + " Edad al finalizar: " + (edad + 5));
            System.out.println("Promedio: " + promedio);
        } while (!correcto);
        System.out.print("""
                Ha sido de su agrado la aplicación?
                1 - Si.
                2 - No.
                """);
        opcion = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea pendiente

        switch (opcion) {
            case 1:
                System.out.println("Nos alegramos. Adios!!!");
                break;
            case 2:
                System.out.println("Lamentamos su descontento.\n" +
                        "Introduzca los motivos.");
                motivo = sc.nextLine();
                System.out.println("Ha indicado que: " + motivo + "\nSaludos");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }
}

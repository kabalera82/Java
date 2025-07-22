package Tema02Condicionales;

import java.util.Scanner;

public class Ejercicio12Fechas {


    public static void main(String[] args) {

        /*
         * Pedir el día, mes y año de una fecha e indicar si la fecha es correcta.
         * Hay que tener en cuenta que existen meses con 28, 30 y 31 días (no se considerará los años bisiestos).
         */
        int dia, mes, año;
        boolean fechaCorrecta; // Inicializar la variable
        try (Scanner sc = new Scanner(System.in)) { // Utilizar try-with-resources
            System.out.println("Introduce el día: ");
            dia = sc.nextInt();
            System.out.println("Introduce el mes: ");
            mes = sc.nextInt();
            System.out.println("Introduce el año: ");
            año = sc.nextInt();

            if (año == 0) { // No existe el año 0
                fechaCorrecta = false;
            } else {
                if (mes == 2 && (1 <= dia && dia <= 28)) {
                    fechaCorrecta = true;
                } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (1 <= dia && dia <= 30)) {
                    fechaCorrecta = true;
                } else fechaCorrecta = 1 <= dia && dia <= 31;
            }

            if (fechaCorrecta) {
                System.out.println("Fecha correcta: " + dia + "/" + mes + "/" + año);
            } else {
                System.out.println("Fecha incorrecta");
            }
            sc.close();
        }


    }
}

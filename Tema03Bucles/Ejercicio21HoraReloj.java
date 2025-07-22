package Tema03Bucles;

import java.util.Scanner;

public class Ejercicio21HoraReloj {

    /**
     * Escribe un programa que incremente la hora de un reloj. Se pedirán por
     * teclado la hora, minutos y segundos, así como cuántos segundos se desea
     * incrementar la hora introdu-cida. La aplicación mostrará la nueva hora.
     * Por ejemplo, si las 13:59:51 se incrementan en 10 segundos, resultan las
     * 14:00:01
     */
    public static void main(String[] args) {
        // Declaramos las variables
        int hora, minutos, segundos, incremento;
        System.out.println("Introduzca hora: ");
        Scanner sc = new Scanner(System.in);
        hora = sc.nextInt();
        System.out.println("Introduzca los minutos: ");
        minutos = sc.nextInt();
        System.out.println("Introduzca los segundos: ");
        segundos = sc.nextInt();
        System.out.println("Cuantos segundos quiere adelantar el reloj: ");
        incremento = sc.nextInt();

        // Incrementar los segundos
        segundos += incremento;
        while (segundos >= 60) {
            segundos = segundos - 60;
            minutos++;
        }

        // Incrementar los minutos
        while (minutos >= 60) {
            minutos = minutos - 60;
            hora++;
        }
        System.out.println("El salto temporal es: " + hora + " horas, " + minutos + " minutos, " + segundos + " segundos");
    }

}

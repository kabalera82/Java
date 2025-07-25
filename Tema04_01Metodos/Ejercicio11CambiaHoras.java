package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio11CambiaHoras {

    /**
     * Escribe un programa que incremente la hora de un reloj.
     * Se pedirán por teclado la hora, minutos y segundos,
     * así como cuántos segundos se desea incrementar la hora introducida.
     * La aplicación mostrará la nueva hora.
     * Por ejemplo, si las 13:59:51 se incrementan en 10 segundos,
     * resultan las 14:00:01
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar la hora, minutos y segundos al usuario
        System.out.println("Introduce la hora: ");
        int hora = sc.nextInt();
        System.out.println("Introduce los minutos: ");
        int minutos = sc.nextInt();
        System.out.println("Introduce los segundos: ");
        int segundos = sc.nextInt();

        // Solicitar cuántos segundos se desea incrementar
        System.out.println("Introduce los segundos a incrementar: ");
        int incremento = sc.nextInt();

        // Incrementar los segundos
        segundos += incremento;

        // Ajustar minutos y horas si los segundos superan 60
        while (segundos >= 60) {
            segundos -= 60;
            minutos++;
        }

        // Ajustar horas si los minutos superan 60
        while (minutos >= 60) {
            minutos -= 60;
            hora++;
        }

        // Ajustar horas si superan 24
        while (hora >= 24) {
            hora -= 24;
        }

        // Mostrar la nueva hora
        System.out.printf("La nueva hora es: %02d:%02d:%02d\n", hora, minutos, segundos);

        // Cerrar el escáner
        sc.close();
    }
}

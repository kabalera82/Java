package Tema99EjerciciosMultiples.campanadas;

import java.time.LocalTime;

/**
 * Crear un programa que lea del teclado dos valores que indican hora de comienzo y hora de fin (ej: 16:30
 * y 19:17), y presente por pantalla la cantidad de veces que un reloj emite campanadas (las campanas se producen en los
 * minutos: 0, 15, 30 y 45). Se supone que la hora de comienzo es menor que la hora de final y ambas pertenecen al mismo
 * día.
 * Por ejemplo, si la hora de comienzo es 9:44 y la hora de fin es 10:01, hay que informar de 2 campanadas.
 * Si la hora de comienzo es 8:00 y la hora de fin es 10:07, el programa debe indicar que sonaron 8 campanadas.
 */
public class Campanadas {

    private static int campanadas() {
        LocalTime inicio = LocalTime.of(9, 44, 0);
        LocalTime horaFin = LocalTime.of(10, 01, 0);
        int inicioMinutos = inicio.toSecondOfDay() / 60;
        int finMinutos = horaFin.toSecondOfDay() / 60;
        if (inicioMinutos > finMinutos) {
            finMinutos += 1440;
        }
        int contador = 0;
        do {
            inicioMinutos++;
            int cuartos = inicioMinutos % 60;
            if (cuartos == 0 || cuartos == 15 ||
                    cuartos == 30 || cuartos == 45) {
                contador++;
                System.out.println("DING");
            }
        } while (inicioMinutos < finMinutos); // condición de parada
        return contador;
    }
    public static void main(String[] args) {
        int total = campanadas();
        System.out.println("Campanadas totales: " + total);
    }
}

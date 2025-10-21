package Tema99EjerciciosMultiples.Algoritmos;

import java.util.Scanner;

public class FIFO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; // Variable de numero de procesos

        System.out.println("introduzca el número de procesos: ");
        n = sc.nextInt();

        // Reservamos Arrays para n procesos esto va a ser el tiempo de llegada
        int[] llegada = new int[n]; // llegada[i] tiempo en eque llega el proceso i cuando aparece en ele sistema
        int[] rafaga = new int[n]; // rafaga[i] es el tiempo de CPU que necesita el proceso
        int[] finalizacion = new int[n]; // finalizacion[i] instante de tiempo en el que termina
        int[] retorno = new int[n]; // retorno[i] tiempo total desde t= 0 hasta que termina
        int[] espera = new int[n]; // espera[i] es cuanto tiempo ha estado esperando el proceso i sin ejecutar
        String[] proceso = new String[n]; // proceso[i] guarda el nombre del proces (P1, P2, ...), para no perderlos al ordenar.

        //Pedimos por teclado los datos de cada proceso uno a uno
        for (int i = 0; i < n; i++) {
            proceso[i] = "p" + (i + 1); // Asignamos un nombre legible
            System.out.println("\nProceso " + proceso[i] + " : ");// Indicamos de que proceso stamos pidiendo los datos.

            System.out.println("Tiempo de llegada: "); // Pedimos el tiempo de llegada (cuando aparece en el sistema).
            llegada[i] = sc.nextInt(); // Guardamos el tiempo de llegada que escribe el usuario

            System.out.println("Tiempo de rafaga: ");// Pedimos el tiempo de ráfaga ( lo que tarda en ejecutarse).
            rafaga[i] = sc.nextInt(); //Guardamos el tiempo de ráfaga que escribe el usuario
        }

        // Calculamos el instante de finalizción de cada proceso siguiendo FIFO (uno detras de otro)
        finalizacion[0] = llegada[0] + rafaga[0]; // El primero cuando llega + su rafaga.
        for (int i = 0; i < n; i++){
            finalizacion[i] = llegada[i-1] + rafaga[i]; // El final del actual = final del anterior + su propia rafaga
        }


        // Calculamos métricas de cada proceso.
        for (int i = 0; i < n; i++) {
            retorno[i] = finalizacion[i]; // 'retorno' lo tomamos como "desde t=0 hasta que termina" (así cuadra con tu imagen).
            // Espera = tiempo total que no estuvo ejecutando.
            // Fórmula: finalización - lo que ejecuta (ráfaga) - cuando llegó
            // Intuición: del tiempo total transcurrido hasta que termina, restas lo que se ejecutó y restas lo que tardó en llegar.
            espera[i] = finalizacion[i] - rafaga[i] - llegada[i];
        }

        // Imprimimos una tabla ordenada para ver todos los datos calculados.
        System.out.println("\n---------------------------------------------------------------"); // Línea decorativa.
        System.out.println("Proceso\tLlegada\tRafaga\tFinal\tRetorno\tEspera"); // Cabecera de columnas con tabuladores.
        System.out.println("---------------------------------------------------------------"); // Línea decorativa.
        for (int i = 0; i < n; i++) { // Recorremos todos los procesos ya ordenados por llegada.
            // Imprimimos: nombre, llegada, ráfaga, final, retorno y espera de cada proceso.
            System.out.println(
                    proceso[i] + "\t" +      // Nombre del proceso (P1, P2, ...).
                            llegada[i] + "\t" +      // Tiempo de llegada.
                            rafaga[i] + "\t" +       // Tiempo de ráfaga.
                            finalizacion[i] + "\t" + // Instante en que termina.
                            retorno[i] + "\t" +      // Tiempo desde t=0 hasta que termina (como en tu gráfico).
                            espera[i]                // Tiempo total que estuvo esperando.
            );
        }

        // Calculamos los promedios (medias) de retorno y de espera.
        double promRetorno = 0, promEspera = 0; // Variables acumuladoras para sumar todos los valores.

        for (int i = 0; i < n; i++) { // Sumamos todos los retornos y todas las esperas.
            promRetorno += retorno[i]; // Acumulamos el retorno del proceso i.
            promEspera += espera[i];   // Acumulamos la espera del proceso i.
        }

        // Mostramos las medias dividiendo entre el número de procesos, con 2 decimales.
        System.out.printf("\nTiempo medio de retorno: %.2f", promRetorno / n); // Imprime la media de retorno (con formato).
        System.out.printf("\nTiempo medio de espera: %.2f", promEspera / n);   // Imprime la media de espera (con formato).
    }
}


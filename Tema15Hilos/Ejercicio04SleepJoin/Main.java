package Tema14Threads.Ejercicio04SleepJoin;

/**
 * Ejercicio 04 - sleep() y join()
 *
 * sleep(ms) — pausa el hilo actual N milisegundos. No libera locks.
 * join()    — el hilo que llama espera a que el hilo objetivo termine.
 * join(ms)  — espera como maximo N milisegundos.
 *
 * Sin join(), el main no sabe cuando terminan los hilos hijos.
 * Con join(), el main espera a que terminen antes de continuar.
 */
public class Main {

    static void tarea(String nombre, int duracionMs) {
        System.out.println(nombre + " iniciado");
        try {
            Thread.sleep(duracionMs);
        } catch (InterruptedException e) {
            System.out.println(nombre + " interrumpido");
            Thread.currentThread().interrupt(); // restaurar estado de interrupcion
        }
        System.out.println(nombre + " terminado (" + duracionMs + "ms)");
    }

    public static void main(String[] args) throws InterruptedException {

        // Sin join — main puede terminar antes que los hilos
        System.out.println("=== Sin join ===");
        Thread t1 = new Thread(() -> tarea("Hilo-1", 300));
        Thread t2 = new Thread(() -> tarea("Hilo-2", 100));
        t1.start();
        t2.start();
        System.out.println("Main continua sin esperar\n");

        // Esperar a que terminen antes de la siguiente demo
        t1.join(); t2.join();

        // Con join — main espera a que terminen en orden
        System.out.println("=== Con join ===");
        Thread descarga = new Thread(() -> tarea("Descarga", 400));
        Thread proceso  = new Thread(() -> tarea("Proceso",  200));

        descarga.start();
        proceso.start();

        descarga.join(); // esperar a que descarga termine
        proceso.join();  // esperar a que proceso termine
        System.out.println("Main: ambos hilos han terminado, continuando...\n");

        // join con timeout — esperar maximo 150ms
        System.out.println("=== join con timeout ===");
        Thread lento = new Thread(() -> tarea("Lento", 500));
        lento.start();
        lento.join(150); // solo espero 150ms

        if (lento.isAlive()) {
            System.out.println("El hilo lento sigue vivo despues del timeout");
            lento.join(); // esperar hasta que termine de verdad
        } else {
            System.out.println("El hilo lento ya habia terminado");
        }

        System.out.println("Main finalizado.");
    }
}

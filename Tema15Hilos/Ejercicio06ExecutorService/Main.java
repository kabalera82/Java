package Tema14Threads.Ejercicio06ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Ejercicio 06 - ExecutorService
 *
 * Crear y gestionar hilos manualmente es propenso a errores.
 * ExecutorService es la forma moderna — gestiona un pool de hilos.
 *
 * newFixedThreadPool(n)  — pool fijo de N hilos
 * newSingleThreadExecutor() — un unico hilo (cola de tareas)
 * newCachedThreadPool()  — crea hilos segun demanda, reutiliza inactivos
 *
 * submit() acepta Runnable (sin retorno) o Callable (con retorno).
 * Future representa el resultado futuro de una tarea asincrona.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // Pool fijo de 3 hilos — solo 3 tareas en paralelo
        System.out.println("=== FixedThreadPool (3 hilos, 6 tareas) ===");
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            final int tarea = i;
            pool.submit(() -> {
                System.out.printf("[%s] Tarea %d iniciada%n",
                    Thread.currentThread().getName(), tarea);
                try { Thread.sleep(300); } catch (InterruptedException e) {}
                System.out.printf("[%s] Tarea %d terminada%n",
                    Thread.currentThread().getName(), tarea);
            });
        }

        // shutdown — no acepta mas tareas, espera a que las actuales terminen
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        // Future — obtener resultado de una tarea asincrona
        System.out.println("\n=== Future con Callable ===");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> futureA = executor.submit(() -> {
            Thread.sleep(200);
            return 42;
        });

        Future<String> futureB = executor.submit(() -> {
            Thread.sleep(100);
            return "Resultado de B";
        });

        // future.get() bloquea hasta que el resultado esta disponible
        System.out.println("Resultado A: " + futureA.get()); // 42
        System.out.println("Resultado B: " + futureB.get()); // "Resultado de B"

        executor.shutdown();

        // SingleThreadExecutor — ejecuta tareas en orden, una a una
        System.out.println("\n=== SingleThreadExecutor (orden garantizado) ===");
        ExecutorService single = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 4; i++) {
            final int n = i;
            single.submit(() -> System.out.println("Tarea " + n + " en " + Thread.currentThread().getName()));
        }

        single.shutdown();
        single.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("\nMain finalizado.");
    }
}

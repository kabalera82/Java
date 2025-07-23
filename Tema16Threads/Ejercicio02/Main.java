package Tema16Threads.Ejercicio02;

public class Main {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        long duracion = 60000; // 1 minuto
        int contador = 0;

        try {
            while (System.currentTimeMillis() - inicio < duracion) {
                new Thread(() -> {
                    try {
                        Thread.sleep(1000000); // Mantén el hilo vivo
                    } catch (InterruptedException e) {}
                }).start();
                contador++;


            }
        } catch (OutOfMemoryError e) {
            System.out.println("🔥 ¡Sin memoria! Hilos totales creados: " + contador);
            return;
        }

        System.out.println("✅ Tiempo terminado. Total de hilos creados: " + contador);
    }
}

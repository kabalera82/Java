package Tema14Threads.Ejercicio05Daemon;

/**
 * Ejercicio 05 - Hilos daemon
 *
 * Hilo daemon — hilo de servicio en segundo plano.
 * La JVM termina cuando TODOS los hilos de usuario han terminado,
 * aunque queden hilos daemon ejecutandose.
 *
 * Se marca ANTES de llamar a start().
 *
 * Uso tipico: recoleccion de basura, monitorizacion, heartbeats.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Hilo daemon — monitor que muestra estado cada 200ms
        Thread monitor = new Thread(() -> {
            int tick = 0;
            while (true) {
                tick++;
                System.out.println("[Monitor daemon] tick " + tick);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    break;
                }
            }
            // Esta linea NO se ejecuta — la JVM termina antes
            System.out.println("[Monitor daemon] terminado limpiamente");
        });

        monitor.setDaemon(true); // ANTES de start()
        monitor.start();

        System.out.println("isDaemon: " + monitor.isDaemon()); // true

        // Hilo de usuario — trabajo real
        Thread trabajador = new Thread(() -> {
            System.out.println("[Trabajador] iniciado");
            try { Thread.sleep(700); } catch (InterruptedException e) {}
            System.out.println("[Trabajador] terminado");
        });

        trabajador.start();
        trabajador.join(); // main espera al trabajador

        // Cuando main y trabajador terminan, la JVM mata el daemon aunque siga corriendo
        System.out.println("Main: trabajo terminado. La JVM terminara y matara el daemon.");
    }
}

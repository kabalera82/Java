//paquete
package Tema16Threads.Ejercicio03SincronizacionHilos;

//Clase Principal
public class AccesoRecursoCompartido {

    // Clase anidada del recurso al que se va a acceder
    static class Recurso {
        public synchronized void mostrarMensaje(String nombreHilo){ //metodo sin retorno que recibe hilo por parametro
            System.out.println("Accediendo al recurso: " + nombreHilo);
            try {
                Thread.sleep(1000); // Simula trabajo durante 1 segundo durmiendo el hilo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Finalizó el acceso: " + nombreHilo);
        }
    }

    // Hilo que accede al recurso compartido
    static class HiloTrabajador extends Thread {
        private final Recurso recurso;
        private final String nombre;

        public HiloTrabajador(Recurso recurso, String nombre) {
            this.recurso = recurso;
            this.nombre = nombre;
        }

        @Override
        public void run() {
            recurso.mostrarMensaje(nombre);
        }
    }

    // Método principal
    public static void main(String[] args) {
        Recurso recursoCompartido = new Recurso();

        // Creamos los hilos
        Thread hilo1 = new HiloTrabajador(recursoCompartido, "Hilo 1");
        Thread hilo2 = new HiloTrabajador(recursoCompartido, "Hilo 2");
        Thread hilo3 = new HiloTrabajador(recursoCompartido, "Hilo 3");

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}

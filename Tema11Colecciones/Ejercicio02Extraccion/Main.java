package Tema11Colecciones.Ejercicio02Extraccion;

/**
 * Implementar con tipo genéricos
 * la clase Contenedor, donde pordremos guardar tantos objetos
 * como deseemos. Para ello utilizaremos una tabla,
 * que inicialmente tendrá tamaño cero y se irá redimensionando
 * según añadamos o eliminemos elementos.
 * La clase, además del constructor y toString(), tendrá los siguientes métodos:
 * void insertarAlPrincipio(T nuevo)
 * void insertarAlFinal(T nuevo)
 * T extraerDelPrincipio()
 * T extraerDelFinal()
 * void ordenar()
 */
public class Main {

    public static void main(String[] args) {
        Contenedor <Integer> c = new Contenedor <>(new Integer[0]);

        c.insertarAlFinal(5);
        c.insertarAlPrincipio(25);
        c.insertarAlFinal(100);
        c.insertarAlPrincipio(1);
        c.insertarAlFinal(6);
        System.out.println("===========================================================================");
        System.out.println("contenedor: " + c);
        System.out.println("===========================================================================");
        c.ordenar();
        System.out.println("ordenado: " + c);
        System.out.println("===========================================================================");
        System.out.println("Extraido del principio: " + c.extraerDatosInicio());
        System.out.println("Extraido del final: " + c.extraerDatosFinal());
        System.out.println("contenedor final: " + c);
    }
}

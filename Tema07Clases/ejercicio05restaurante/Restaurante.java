package Tema07Clases.ejercicio05restaurante;

/**
 * Tema 7: [Clases]
 * <p>
 * Ejercicio 05: [Creación de la Clase Restaurante]
 *
 * @author kabadev
 */
public class Restaurante {
    //Atributos
    private static int huevos; //cantidad de huevos unidades
    private static int chorizo; // cantidad peso chorizo

    //constructor: iniciliza los valores de huevos y chorizo
    public Restaurante(int huevos, double chorizos) {
        huevos = huevos * 12;
        chorizo = (int) (chorizo * 1000);
    }

    // Incrementa el número de huevos
    void addHuevos(int num) {
        huevos = huevos + (num * 12);
    }

    //Incrementarmos la cantidad de chorizo 
    void addChorizo(double num) {
        chorizo = (int) (chorizo + (num * 1000));
    }

    //Calcular cuantos platos se pueden cocinar
    int getNumPlatos() {
        //Calculamos nº platos posibles con slos huevos actuales
        int n1 = huevos / 2;
        //Calculamos nº platos posibles con los chorizos actuales
        int n2 = chorizo / 200; // Cada plato necesita 200gr de addChorizo
        // El número máximo de platos que se pueden preparar
        //será el menor entre n1 y n2.
        if (n1 < n2) {
            return n1;
        } else {
            return n2;
        }
    }

    //Restar yba cabtudad ak byneri de huevos y chorizos
    //como resultado de haber servido un plato
    // 2 huevos menos y 200 gramos de chorizo
    void sirvePlato() {
        huevos = huevos - 2;
        chorizo = chorizo - 200;
    }

    // Devuelve el número actual de huevos.
    int getHuevos() {
        return huevos;
    }

    // Devuleve el número actual de kg de chorizo
    double getChorizo() {
        return ((double) chorizo / 1000);
    }


}

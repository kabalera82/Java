package Tema11Colecciones.Ejercicio02Extraccion;


import java.util.Arrays;

// Usamos la clase Comparable para que se ordene la tabla
public class Contenedor<Tabla extends Comparable <Tabla>>{

    /* Instanciamos la tabla y se la pasamos como parámetro, ¿por qué? =================================================
     *
     * - Los genéricos se disfrazan al compilar: Tabla[] se convierte en Object[],
     *   así que Java no sabe qué tipo exacto es realmente en tiempo de ejecución.
     *
     * - Los arrays protegen su tipo: si dices String[], solo puede contener Strings.
     *   Java lanza errores si intentas meter otro tipo.
     *
     * - Mezclar genéricos con arrays causa conflictos: uno pierde su tipo (genérico)
     *   y el otro lo necesita (array), por eso no se pueden combinar fácilmente.
     *
     * - Si no sabemos qué hay dentro, no podemos construirlo: no se puede hacer `new T[10]`
     *   porque Java no sabe qué es `T` en ese momento.
     *
     * - Para guardar cosas genéricas, usamos ArrayList<T>: funciona bien porque internamente
     *   guarda los objetos sin necesidad de conocer el tipo exacto en tiempo de ejecución.
     * =================================================================================================================
     * */

    // Atributos
    public Tabla [] objetos;

    // Constructor genérico
    public Contenedor(Tabla[] objetos) {
        this.objetos = objetos;
    }

    // Metodos
    // En estos métodos no solo estamos rescatando el valor sino que generamos copias excluyendo esos datos
    //==================================================================================================================
    void insertarAlFinal(Tabla nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length + 1);
        objetos[objetos.length -1] = nuevo;
    }
    //==================================================================================================================
    void insertarAlPrincipio(Tabla nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length + 1);
        System.arraycopy(objetos, 0, objetos, 1, objetos.length -1);
        objetos[0] = nuevo;
    }
    //==================================================================================================================
    Tabla extraerDatosFinal () {
        Tabla extraido = this.objetos[this.objetos.length -1];
        this.objetos = Arrays.copyOf(this.objetos, this.objetos.length - 1 );
        return extraido;
    }
    //==================================================================================================================
    Tabla extraerDatosInicio () {
        Tabla extraido = this.objetos[0]; // Guardamos el primer elemento
        Tabla [] nuevoArray = Arrays.copyOfRange(this.objetos, 1, this.objetos.length);
        this.objetos = nuevoArray;
        return extraido;
    }
    //==================================================================================================================
    public void ordenar() {
        Arrays.sort(this.objetos);
    }
    //==================================================================================================================
    @Override
    public String toString() {
        return Arrays.toString(this.objetos);
    }
}

package Tema06CadenasDeCaracteres;

/**
 * Ejercicio 06 - StringBuilder
 *
 * String es INMUTABLE — concatenar con + en un bucle crea objetos nuevos
 * en cada iteracion. Con 10.000 iteraciones eso es muy ineficiente.
 *
 * StringBuilder es MUTABLE — modifica el mismo objeto en memoria.
 * Usar StringBuilder cuando se concatena en bucles o se hacen muchas modificaciones.
 */
public class Ejercicio06StringBuilder {

    public static void main(String[] args) {

        // Diferencia de rendimiento
        int n = 10000;

        long inicio = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += i; // crea un nuevo String en cada iteracion
        }
        System.out.println("String concatenacion: " + (System.currentTimeMillis() - inicio) + " ms");

        inicio = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i); // modifica el mismo objeto
        }
        System.out.println("StringBuilder:        " + (System.currentTimeMillis() - inicio) + " ms");

        // Metodos de StringBuilder
        StringBuilder builder = new StringBuilder("Hola");

        builder.append(", Mundo");          // añade al final
        System.out.println("\nappend:   " + builder);

        builder.insert(4, " Java");         // inserta en posicion 4
        System.out.println("insert:   " + builder);

        builder.delete(4, 9);              // elimina de 4 a 9
        System.out.println("delete:   " + builder);

        builder.replace(0, 4, "Buenos dias"); // reemplaza rango
        System.out.println("replace:  " + builder);

        builder.reverse();                  // invierte
        System.out.println("reverse:  " + builder);

        builder.reverse();                  // vuelve a invertir
        System.out.println("original: " + builder);

        System.out.println("length:   " + builder.length());
        System.out.println("charAt(0):" + builder.charAt(0));

        // Convertir a String
        String resultado = builder.toString();
        System.out.println("toString: " + resultado);

        // Construir tabla con StringBuilder
        System.out.println("\n=== Tabla de cuadrados ===");
        StringBuilder tabla = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            tabla.append(String.format("%-5d -> %d%n", i, i * i));
        }
        System.out.print(tabla);
    }
}

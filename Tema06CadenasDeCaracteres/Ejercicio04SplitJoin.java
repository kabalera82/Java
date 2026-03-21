package Tema06CadenasDeCaracteres;

import java.util.Arrays;

/**
 * Ejercicio 04 - split(), join() y tokenizacion
 *
 * split() divide un String por un separador — devuelve array de String.
 * join() une un array o lista con un separador.
 */
public class Ejercicio04SplitJoin {

    public static void main(String[] args) {

        // split — dividir por separador
        String csv = "Ana,Luis,Maria,Pedro,Carmen";
        String[] nombres = csv.split(",");
        System.out.println("Nombres: " + Arrays.toString(nombres));
        System.out.println("Total: " + nombres.length);

        // split con limite — solo divide N veces
        String datos = "nombre:apellido:ciudad:pais";
        String[] partes = datos.split(":", 2); // maximo 2 partes
        System.out.println("\nSplit con limite 2: " + Arrays.toString(partes));
        // [nombre, apellido:ciudad:pais]

        // split con regex — dividir por espacios multiples
        String frase = "Hola   mundo    Java";
        String[] palabras = frase.split("\\s+"); // uno o mas espacios
        System.out.println("\nPalabras: " + Arrays.toString(palabras));

        // join — unir con separador
        String unido = String.join(" - ", nombres);
        System.out.println("\nJoin: " + unido);

        String unidoComa = String.join(", ", "uno", "dos", "tres");
        System.out.println("Join inline: " + unidoComa);

        // Caso practico — parsear linea de datos
        System.out.println("\n=== Parsear datos de empleados ===");
        String[] empleados = {
            "001;Ana Garcia;Desarrollo;45000",
            "002;Luis Perez;Marketing;38000",
            "003;Maria Lopez;RRHH;42000"
        };

        for (String linea : empleados) {
            String[] campos = linea.split(";");
            System.out.printf("ID: %s | Nombre: %-15s | Depto: %-12s | Salario: %s€%n",
                campos[0], campos[1], campos[2], campos[3]);
        }
    }
}

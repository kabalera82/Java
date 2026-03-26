package Tema11_02FicherosBinarios.Ejercicio05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 05 — Serialización y deserialización de objetos con
 * {@link ObjectOutputStream} y {@link ObjectInputStream}.
 *
 * <p>El programa crea una lista de objetos {@link Socio}, la serializa al
 * fichero {@code socios.dat}, y a continuación la deserializa y muestra
 * los datos por pantalla.</p>
 *
 * <p><b>[APRENDE] — ¿Qué es la serialización?</b><br>
 * Serializar = convertir un objeto Java (que vive en memoria RAM) en una
 * secuencia de bytes que puede guardarse en disco, enviarse por red o
 * almacenarse en una base de datos. Deserializar es el proceso inverso:
 * reconstruir el objeto original a partir de esos bytes.<br>
 * La serialización Java guarda el estado de TODOS los campos del objeto
 * y la información de la clase.</p>
 *
 * <p><b>[APRENDE] — ObjectOutputStream vs DataOutputStream</b><br>
 * <ul>
 *   <li>{@link DataOutputStream}: solo para primitivos y Strings sueltos.
 *       Control total, formato compacto, eficiente.</li>
 *   <li>{@link ObjectOutputStream}: para objetos completos que implementan
 *       {@link java.io.Serializable}. Guarda el grafo entero del objeto,
 *       incluyendo objetos referenciados. Más potente, más overhead.</li>
 * </ul></p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Main {

    /** Ruta del fichero donde se serializan los socios. */
    private static final String FICHERO_SOCIOS = "data/socios.dat";

    /**
     * Punto de entrada principal.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        // Creamos los datos de ejemplo
        List<Socio> socios = crearSocios();

        // Paso 1: serializar al disco
        serializarSocios(socios);

        // Paso 2: deserializar y mostrar
        List<Socio> sociosRecuperados = deserializarSocios();
        mostrarSocios(sociosRecuperados);
    }

    // =========================================================================
    // Datos de ejemplo
    // =========================================================================

    /**
     * Crea y devuelve una lista con tres socios de ejemplo.
     *
     * @return lista de socios
     */
    private static List<Socio> crearSocios() {
        List<Socio> lista = new ArrayList<>();
        lista.add(new Socio(1, "Ana García",   "ana.garcia@email.com",   true));
        lista.add(new Socio(2, "Luis Martínez", "luis.martinez@email.com", true));
        lista.add(new Socio(3, "Carmen López",  "carmen.lopez@email.com",  false));
        return lista;
    }

    // =========================================================================
    // PASO 1 — Serialización
    // =========================================================================

    /**
     * Serializa la lista de socios en el fichero {@value #FICHERO_SOCIOS}.
     *
     * <p><b>[APRENDE] — writeObject()</b><br>
     * Este método convierte cualquier objeto {@link java.io.Serializable} en
     * bytes. Aquí serializamos la lista ENTERA de una sola llamada. Java es
     * lo suficientemente inteligente para serializar también todos los objetos
     * que la lista contiene internamente (los {@link Socio}).</p>
     *
     * @param socios lista de socios a serializar
     */
    private static void serializarSocios(List<Socio> socios) {
        System.out.println("=== SERIALIZACIÓN ===");

        // [APRENDE] — ObjectOutputStream envuelve FileOutputStream.
        // La cadena de streams es: datos en memoria -> ObjectOutputStream (convierte a bytes)
        // -> FileOutputStream (escribe bytes en disco).
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FICHERO_SOCIOS))) {

            // Serializamos la lista completa de una sola vez.
            // Java recorrerá la lista y serializará cada Socio que contiene.
            oos.writeObject(socios);

            System.out.printf("Se han serializado %d socio(s) en '%s'.%n%n",
                    socios.size(), FICHERO_SOCIOS);

        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }
    }

    // =========================================================================
    // PASO 2 — Deserialización
    // =========================================================================

    /**
     * Deserializa la lista de socios desde el fichero {@value #FICHERO_SOCIOS}.
     *
     * <p><b>[APRENDE] — readObject() y el cast</b><br>
     * {@code readObject()} devuelve {@link Object}: Java no sabe en tiempo de
     * compilación qué tipo guardaste. Tú DEBES hacer el cast explícito al tipo
     * correcto. Si el tipo no coincide, lanzará {@link ClassCastException}.<br>
     * La anotación {@code @SuppressWarnings("unchecked")} silencia el warning
     * del compilador sobre el cast genérico {@code List<Socio>}; es seguro
     * porque sabemos lo que escribimos nosotros mismos.</p>
     *
     * @return lista de socios recuperados, o lista vacía si hay error
     */
    @SuppressWarnings("unchecked")
    private static List<Socio> deserializarSocios() {
        System.out.println("=== DESERIALIZACIÓN ===");

        // [APRENDE] — La cadena inversa: FileInputStream (lee bytes de disco)
        // -> ObjectInputStream (reconstruye objetos Java desde esos bytes).
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FICHERO_SOCIOS))) {

            // readObject() reconstruye el grafo de objetos completo.
            // El cast es necesario porque readObject() devuelve Object.
            List<Socio> socios = (List<Socio>) ois.readObject();

            System.out.printf("Se han deserializado %d socio(s) desde '%s'.%n%n",
                    socios.size(), FICHERO_SOCIOS);

            return socios;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // =========================================================================
    // Presentación
    // =========================================================================

    /**
     * Muestra la lista de socios por consola en formato tabla.
     *
     * @param socios lista de socios a mostrar
     */
    private static void mostrarSocios(List<Socio> socios) {
        System.out.println("=== SOCIOS RECUPERADOS ===");
        System.out.printf("%-5s %-20s %-30s %-8s%n", "ID", "NOMBRE", "EMAIL", "ACTIVO");
        System.out.println("-".repeat(65));

        for (Socio s : socios) {
            System.out.printf("%-5d %-20s %-30s %-8s%n",
                    s.getId(),
                    s.getNombre(),
                    s.getEmail(),
                    s.isActivo() ? "SI" : "NO");
        }

        System.out.println("-".repeat(65));
    }
}

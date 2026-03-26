package Tema11_02FicherosBinarios.Ejercicio05;

import java.io.Serial;
import java.io.Serializable;

/**
 * Modelo de dominio que representa un socio del sistema.
 *
 * <p><b>[APRENDE] — Serializable</b><br>
 * Para que Java pueda convertir un objeto en bytes (y luego reconstruirlo),
 * la clase DEBE implementar la interfaz {@link Serializable}. Es una interfaz
 * <em>marcadora</em> (no tiene métodos): simplemente le dice a la JVM
 * "este objeto puede ser serializado".</p>
 *
 * <p><b>[APRENDE] — serialVersionUID</b><br>
 * Es un identificador de versión del esquema de serialización. Cuando Java
 * deserializa un objeto, compara el {@code serialVersionUID} del fichero con
 * el de la clase actual. Si no coinciden, lanza
 * {@link java.io.InvalidClassException}.<br>
 * Si NO lo declaras, Java lo calcula automáticamente a partir de los campos
 * y métodos de la clase. Eso significa que si añades o cambias un campo,
 * el UID cambia y ya no podrás leer ficheros antiguos. Declararlo explícitamente
 * te da control: puedes decidir cuándo romper la compatibilidad.</p>
 *
 * <p><b>[APRENDE] — ¿Qué pasa si cambias la clase después de serializar?</b><br>
 * <ul>
 *   <li>Añadir un campo nuevo → el campo tendrá el valor por defecto al
 *       deserializar objetos viejos (0, null, false). Si el UID no cambió,
 *       funciona.</li>
 *   <li>Eliminar un campo → el campo simplemente se ignora al deserializar.
 *       Si el UID no cambió, funciona.</li>
 *   <li>Cambiar el tipo de un campo → incompatible, lanza excepción aunque
 *       el UID sea el mismo.</li>
 *   <li>Cambiar el UID → cualquier fichero serializado con el UID antiguo
 *       dejará de poder deserializarse.</li>
 * </ul></p>
 *
 * @author Kabalera
 * @version 1.0
 */
public class Socio implements Serializable {

    /**
     * [APRENDE] — Declaramos el UID explícitamente para tener control de versiones.
     * Convención habitual: empezar en 1L y cambiar manualmente cuando la
     * estructura del objeto cambie de forma incompatible.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /** Identificador único del socio. */
    private int id;

    /** Nombre completo del socio. */
    private String nombre;

    /** Correo electrónico del socio. */
    private String email;

    /** Indica si el socio está activo o dado de baja. */
    private boolean activo;

    // ===================== CONSTRUCTOR =====================

    /**
     * Crea un nuevo socio con todos sus campos.
     *
     * @param id     identificador único
     * @param nombre nombre completo
     * @param email  correo electrónico
     * @param activo {@code true} si el socio está activo
     */
    public Socio(int id, String nombre, String email, boolean activo) {
        this.id     = id;
        this.nombre = nombre;
        this.email  = email;
        this.activo = activo;
    }

    // ===================== GETTERS =====================

    /** @return el identificador del socio */
    public int getId() { return id; }

    /** @return el nombre del socio */
    public String getNombre() { return nombre; }

    /** @return el email del socio */
    public String getEmail() { return email; }

    /** @return {@code true} si el socio está activo */
    public boolean isActivo() { return activo; }

    // ===================== toString =====================

    @Override
    public String toString() {
        return String.format(
            "Socio { id=%d, nombre='%s', email='%s', activo=%s }",
            id, nombre, email, activo ? "SI" : "NO"
        );
    }
}

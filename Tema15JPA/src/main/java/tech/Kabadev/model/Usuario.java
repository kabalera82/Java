package tech.Kabadev.model;

// imports  ==================================================================================================
import java.util.Objects;

/**
 * POJO (Plain Old Java Object) util para operaciones CRUD.
 *
 * <p>
 *     Incluye múltiples constructores para distintos casos de uso
 *     (creación sin id, referencia por id, o carga completa desde la base de datos).
 * </p>
 *
 *  @author Marcos
 *  @version 1.0
 *  @since 1.0
 */

public class Usuario {
    //Atributos  ===============================================================================================
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String email;


    // Constructores ===============================================================================================

    /**
     * Constructor sin argumentos.
     * <p>
     * Necesario para frameworks que instancian por reflexión (p. ej. JPA/Hibernate/JSON).
     * Permite crear el objeto y completar sus valores vía setters.
     * </p>
     */
    public Usuario () {}

    /**
     * Útil cuando solo conoces el identificador (ej. consultas rápidas a BBDD, operaciones DELETE o UPDATE).
     * @param id
     */
    public Usuario(int id){
        this.id= id;
    }

    /**
     * Constructor con datos con excepción del ID.
     *
     * Sirve cuando vas a insertar un nuevo cliente en la BBDD.
     * No se tiene que asignar id porque se suele generar en la bbdd con AUTO_INCREMENT
     *
     * @param nombre
     * @param primerApellido
     * @param segundoApellido
     * @param telefono
     * @param email
     */
    public Usuario(String nombre, String primerApellido, String segundoApellido, String telefono, String email) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Constructor con todos los parámetros.
     * <p>Reutiliza el constructor sin {@code id} para inicializar los atributos comunes,
     * y posteriormente asigna el identificador.</p>
     *
     * @param id identificador único del usuario
     * @param nombre nombre del usuario
     * @param primerApellido primer apellido del usuario
     * @param segundoApellido segundo apellido del usuario
     * @param telefono número de teléfono de contacto
     * @param email correo electrónico de contacto
     */
    public Usuario(int id, String nombre, String primerApellido,
                   String segundoApellido, String telefono, String email) {
        this(nombre, primerApellido, segundoApellido, telefono, email);
        this.id = id;
    }

    // getters & setters  ===============================================================================================

    /** @return id*/
    public int getId(){
        return id;
    }
    /** @param id */
    public void setId(int id){
        this.id=id;
    }

    /**@return nombre usuario*/
    public String getNombre(){
        return nombre;
    }
    /**@param nombre del usuario*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**@return primerApellido del usuario*/
    public String getPrimerApellido(){
        return primerApellido;
    }
    /**@param primerApellido del usuario*/
    public void setPrimerApellido(String primerApellido){
        this.primerApellido = primerApellido;
    }

    /** @return segundoApellido del usuario*/
    public String getSegundoApellido(){
        return segundoApellido;
    }
    /** @param segundoApellido del usuario*/
    public void setSegundoApellido(String segundoApellido){
        this.segundoApellido = segundoApellido;
    }

    /** @return telefono*/
    public String getTelefono(){
        return telefono;
    }
    /**@param telefono*/
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    /**@return email*/
    public String getEmail(){
        return email;
    }
    /** @param email*/
    public void setEmail(String email){
        this.email = email;
    }

    // Metodo toString  ===============================================================================================
    /**
     * Devuelve una representación en texto del objeto{@code Usuario}.
     * <p> Incluye todos los atributos propios de la clase USuario</p>
     * <p> Es útil para la depuración, logs y mostrar información en consola.</p>
     * @return cadena con el formato deseado.
     */
    @Override
    public String toString() {
        return "Datos del Cliente:" +
                "- id: " + id + "\n" +
                "- nombre: " + nombre + "\n" +
                "- primer apellido: " + primerApellido + "\n" +
                "- segundo apellido: " + segundoApellido + "\n" +
                "- teléfono: " + telefono + "\n" +
                "- email: " + email + "\n";
    }

    // Metodo equals  ===============================================================================================
    /**
     *  Metodo que compara este Objeto con otro para determinar si son iguales.
     *  <p>Dos clientes se consideran iguales si tiene todos sus parametros iguales.</p>
     *
     * @param objeto con el que se compara
     * @return  {code true} si ambos Usuarios tienen los mismos atributos,
     *          {code false} en caso contrario.
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Usuario usuario = (Usuario) objeto;
        return id == usuario.id &&
                nombre == usuario.nombre &&
                primerApellido == usuario.primerApellido &&
                segundoApellido == usuario.segundoApellido &&
                telefono == usuario.telefono &&
                email == usuario.email &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(primerApellido, usuario.primerApellido) &&
                Objects.equals(segundoApellido, usuario.segundoApellido) &&
                Objects.equals(telefono, usuario.telefono) &&
                Objects.equals(email, usuario.email);
    }


    // Metodo hashCode  ===============================================================================================
    /**
     * Calcula un valor hash para este Usuario.
     * <p> Es consistente con {@link #equals(Object)}: si do clientes son iguales
     * sus valores también lo serán.</p>
     * <p>Este metodo es fundamental para estructuras de datos basadas en hash como {@code HashSet} o {@code HashMap}:</p>
     * @return un valor entero representando el codigo hash del cliente
     */
    @Override
    public int hashCode(){
        //genera automaticamente un hash combinando todos los atributos
        return Objects.hash(id, nombre, primerApellido, segundoApellido, telefono, email);
    }
}

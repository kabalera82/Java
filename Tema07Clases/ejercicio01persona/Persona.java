package Tema07Clases.ejercicio01persona;

/**
 * Tema 7: [Clases]
 * <p>
 * Ejercicio 01: [Creación de la Clase Persona]
 *
 * @author kabadev
 */

public class Persona {

    //Declaracion de Atributos
    //Los atributos NO son static, porque son compartidos por todas las instancias de la clase.
    // Es decir cada persona debe tener su propio nombre, edad, etc.
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String dni;
    private String telefono;
    private int edad;


    //Constructor con Parámetros
    public Persona(String nombre, String primerApellido, String segundoApellido, int edad, String dni, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
        this.dni = dni;
        this.telefono = telefono;
    }

    // === Getters and Setters ==================================================
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return " nombre: '" + nombre + '\'' +
                ", primer apellido: '" + primerApellido + '\'' +
                ", segundo apellido: '" + segundoApellido + '\'' +
                ", dni: '" + dni + '\'' +
                ", telefono: '" + telefono + '\'' +
                ", edad: " + edad;
    }
}

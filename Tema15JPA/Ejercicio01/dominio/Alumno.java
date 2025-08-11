package Tema15JPA.Ejercicio01.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 - Escribimos la clase Alumno con los atributos
 - Esta clase es lo que denominamos un POJO
 */

@Entity
public class Alumno implements java.io.Serializable {
    @Id
    @GeneratedValue
    private int numero;
    private String nombre;
    private String direccion;
    private String dni;
    private double notaMedia;

    // Constructor sin parámetros que necesita JPA
    protected Alumno(){};

    // Constructor por Defecto.
    public Alumno(int numero, String nombre, String direccion, String dni, Double notaMedia){
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.notaMedia = notaMedia;
    }

    public void setNumero (int numero){
        this.numero = numero;
    }
    public int getNumero(){
        return numero;
    }

    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setDireccion (String direccion){
        this.direccion = direccion;
    }
    public String getDireccion(){
        return direccion;
    }

    public void setDni (String dni){
        this.dni = dni;
    }
    public String getDni(){
        return dni;
    }
    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
    @Override

    @Override
    public String toString() {
        return "Alumno{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dni='" + dni + '\'' +
                ", notaMedia=" + notaMedia +
                '}';
    }
}

package Tema99EjerciciosMultiples.Alumnos;


import java.util.Objects;


public class Alumno implements ICurso{

    // Atibutos
    private String nombre;
    private String Apellidos;
    private String DNI;
    private Double notaNum;
    private String notaStr;

    // Constructor
    public Alumno(String nombre, String apellidos, String DNI, Double notaNum, String notaStr) {
        this.nombre = nombre;
        Apellidos = apellidos;
        this.DNI = DNI;
        this.notaNum = notaNum;
        this.notaStr = notaStr;
    }

    public void pertenece(){
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Double getNotaNum() {
        return notaNum;
    }

    public void setNotaNum(Double notaNum) {
        this.notaNum = notaNum;
    }

    public String getNotaStr() {
        return notaStr;
    }

    public void setNotaStr(String notaStr) {
        this.notaStr = notaStr;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(Apellidos, alumno.Apellidos) && Objects.equals(DNI, alumno.DNI) && Objects.equals(notaNum, alumno.notaNum) && Objects.equals(notaStr, alumno.notaStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, Apellidos, DNI, notaNum, notaStr);
    }
}

package Tema99EjerciciosMultiples.Alumnos;


import java.util.Objects;


public class Alumno {

    // Atibutos
    private String nombre;
    private String apellidos;
    private String DNI;
    private Double notaNum;
    private String notaStr;

    // Constructor
    public Alumno(String nombre, String apellidos, String DNI, Double notaNum) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.setNotaNum(notaNum);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNotaNum() {
        return notaNum;
    }

    public void setNotaNum(double notaNum) {
        this.notaNum = notaNum;
        if (notaNum == 0) this.notaStr = "No presentado";
        else if (notaNum < 5) this.notaStr = "Suspenso";
        else if (notaNum < 7) this.notaStr = "Aprobado";
        else if (notaNum < 9) this.notaStr = "Notable";
        else if (notaNum < 10) this.notaStr = "Sobresaliente";
        else this.notaStr = "Matricula Honor";
    }

    public String getNotaStr() {
        return notaStr;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos) && Objects.equals(DNI, alumno.DNI) && Objects.equals(notaNum, alumno.notaNum) && Objects.equals(notaStr, alumno.notaStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, DNI, notaNum, notaStr);
    }


    @Override
    public String toString() {
        return "Alumno: '"+ nombre + "'"+'\''
                            + apellidos + '\'' +
                ", '" + DNI + '\'' +
                ", " + notaNum +
                ", '" + notaStr + '\'';
    }
}

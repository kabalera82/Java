package Tema99EjerciciosMultiples.Alumnos;

/**
 * Implementar un programa para gestión de una clase sin suponer ningún número de alumnos máximo.
 * Para ello se utilizará una lista.
 *
 * Para cada alumno se almacenará la siguiente información: Nombre, Apellidos, DNI, Nota en número, y Nota en letra.
 * Crea la clase Alumno.
 * Implementa la clase Curso cuyo atributo es una lista de tipo Alumno.
 *
 * El programa permitirá las siguientes operaciones, en un menú de opciones:
 *
 * Añadir nuevo alumno.
 * Borrar alumno ya existente (dando su posición en la lista y/o su nombre, como se prefiera).
 * Cambiar algún dato de algún alumno: Modificar sus notas...
 * Mostrar todos los datos de todos los alumnos (uno a uno, por ejemplo).
 * Cambiar la nota en letra de cada alumno según su nota numérica: No presentado (<0), Suspenso (<5), Aprobado (<7), Notable (<9), Sobresaliente (<10) y Matrícula de Honor (10).
 * Mostrar el total de alumnos de cada nota (Suspenso, Aprobado...) y el porcentaje que suponen respecto al total de alumnos en la lista y respecto al total de alumnos presentados (excluyendo los No Presentados).
 */
public class Main {

    Alumno a1 = new Alumno("María", "Pérez López", "56566759R", 8.05, "Notable");
    Alumno a2 = new Alumno("Carlos", "García Ruiz", "23894412M", 6.75, "Bien");
    Alumno a3 = new Alumno("Lucía", "Fernández Soto", "77451233A", 9.20, "Sobresaliente");
    Alumno a4 = new Alumno("Pablo", "Martínez Gómez", "11234589T", 4.80, "Insuficiente");
    Alumno a5 = new Alumno("Ana", "Rodríguez León", "66549213L", 7.10, "Notable");
    Alumno a6 = new Alumno("David", "Sánchez Ortega", "99831572J", 5.30, "Suficiente");
    Alumno a7 = new Alumno("Laura", "Jiménez Díaz", "88766345C", 9.85, "Sobresaliente");
    Alumno a8 = new Alumno("Jorge", "Navarro Torres", "22984577V", 3.95, "Insuficiente");
    Alumno a9 = new Alumno("Claudia", "Morales Vega", "33214599B", 6.40, "Bien");
    Alumno a10 = new Alumno("Sergio", "López Martín", "77123384K", 7.90, "Notable");





    public static void main (String[] args){

    }
}

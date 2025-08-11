package Tema15JPA.Ejercicio01;

import Tema15JPA.Ejercicio01.dao.AlumnoDAO;
import Tema15JPA.Ejercicio01.dominio.Alumno;

public class Main {
    public static void main(String[] args) {
        AlumnoDAO dao = new AlumnoDAO();

        // Crear alumno
        Alumno alumno = new Alumno("Juan Pérez", "Calle Falsa 123", "12345678A", 8.5);
        dao.guardar(alumno);

        // Listar todos
        dao.listarTodos().forEach(System.out::println);

        // Buscar por ID
        Alumno encontrado = dao.buscarPorId(1);
        System.out.println("Encontrado: " + encontrado);
    }
}
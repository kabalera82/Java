package tech.Kabadev.gui;

//imports

import tech.Kabadev.conexion.Conexion;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        /**
         * Punto de entrada de prueba para verificar rápidamente la conectividad con la base de datos.
         *
         * <p>No forma parte de la lógica de negocio; su propósito es diagnóstico/manual.
         * Imprime por consola si la conexión fue exitosa o no.</p>
         *
         * @param args argumentos de línea de comandos (no utilizados).
         */
        // Cuando es un metodo estatico accedemos al nombre de la clase0. y al metodo estatico
        Connection conexion = Conexion.getConexion();
        if (conexion != null) {
            System.out.println("Conexion Correcta");
        } else {
            System.out.println("Error al conectar a la ddbb");
        }
    }
}
package tech.Kabadev;


import tech.Kabadev.conexion.Conexion;

public class Main {
    public static void main(String[] args) {

        // Cuando es un metodo estatico accedemos al nombre de la clase . y al metodo estatico
        var conexion = Conexion.getConexion();
        if(conexion !=null){
            System.out.println("Conexion Correcta");
        } else {
            System.out.println("Error al conectar a la ddbb");
        }
    }
}
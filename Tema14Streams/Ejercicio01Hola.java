package Tema13Streams;
/*
 - Definir una interfaz funcional cuya funcion abstracta.
 genera un salido dirigido al objeto que se la pasa por parametro
 - Implementa un saludo para nombres (Clase String).
 - Implementa un saludo para clientes (Clase Cliente).
 */


import Tema13Streams.Cliente;


public class Ejercicio01Hola {
    public static void main(String[] args) {

        // Saludo para String
        ISaludo<String> saludoNombre = s -> "Hola " + s + "!";
        System.out.println(saludoNombre.saludar("Marcos"));
        System.out.println(saludoNombre.saludar("Maria"));

        // Saludo para Cliente
        ISaludo<Cliente> saludoCliente = c -> "Buenos días " + c.getNombre() + "!";
        System.out.println(saludoCliente.saludar(
                new Cliente("115", "Maria", "12/02/2020")
        ));
    }
}

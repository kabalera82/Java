package Tema04Metodos;

public class Ejercicio08GeneradorEmails {

    public static void generadorEmailUnico() {
        // Aquí puedes implementar la lógica para generar un email único
        // Por ejemplo, podrías combinar el nombre, apellido y un número aleatorio
        System.out.println("***Generador de Email único iniciado.***");
        var consola = new java.util.Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        // Capturamos el nombre del usuario
        var nombre = consola.nextLine().toLowerCase();
        System.out.println("Introduce tu apellido: ");
        // Capturamos el apellido del usuario
        var apellido = consola.nextLine().toLowerCase();
        var dominio = "kabadev.tech";
        var emailGenerado = nombre + "." + apellido + "@" + dominio;
        // Mostramos el email generado
        System.out.println("Tu email único es: " + emailGenerado);
    }


    public static void main(String[] args) {
        generadorEmailUnico();

    }
}

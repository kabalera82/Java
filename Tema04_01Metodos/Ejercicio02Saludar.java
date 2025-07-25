package Tema04_01Metodos;

public class Ejercicio02Saludar {

    //Definimos la funcion saludar
    //static ebido a que main es estatico
    // El modificador static indica que el método pertenece a la clase, no a una instancia
    // El método saludar toma un argumento de tipo String y no devuelve nada (void)
    // Este método imprime un mensaje de saludo en la consola
    static void saludar(String mensaje) {
        System.out.println("Mensaje: " + mensaje);
    }


    // Método main para ejecutar la clase (punto de entrada)
    // Este método se ejecuta al iniciar el programa
    // Aquí se puede llamar al método saludar con diferentes argumentos    
    public static void main(String[] args) {
        saludar("¡Bienvenido!"); // Llama al método saludar con argumento
        saludar("Adios¡");
    }
}
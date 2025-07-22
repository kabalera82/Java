package Tema07Clases.ejercicio05restaurante;

public class Main {
    // Prueba de Restaurante
    public static void main(String[] args) {

        // Pruebas de Restaurante
        Restaurante rest = new Restaurante(4, 10);

        System.out.println("""
                Probamos el restaurante
                Estado inicial:
                """);
        System.out.println("Huevos = " + rest.getHuevos() + "\n"
                + "Chorizo = " + rest.getChorizo() + "kg" + "\n"
                + "Número de platos que se pueden preparar = " + "\n"
                + rest.getNumPlatos());

        rest.addHuevos(2);
        rest.addChorizo(9);

        System.out.println("Estado despues de añadir huevos y chorizo: " + "\n"
                + "Huevos = " + rest.getHuevos() + "\n"
                + "Chorizo = " + rest.getChorizo() + "kg" + "\n"
                + "Numero de platos que se pueden preparar = " + "\n"
                + rest.getNumPlatos()
        );

        //Servimos los platos (5 en este caso)
        rest.sirvePlato(); // 1
        rest.sirvePlato(); // 2
        rest.sirvePlato(); // 3
        rest.sirvePlato(); // 4
        rest.sirvePlato(); // 5

        System.out.println("Estado después de servir cinco platos más: " + "\n"
                + "Huevos = " + rest.getHuevos() + "\n"
                + "Chorizo = " + rest.getChorizo() + "\n"
                + "Número de platos que se puede preparar = " + rest.getNumPlatos() + "\n"
        );

    }
}

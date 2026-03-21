package Tema06CadenasDeCaracteres;

/**
 * Ejercicio 07 - Formato de cadenas
 *
 * String.format() crea un String formateado sin imprimir.
 * System.out.printf() imprime directamente con el mismo formato.
 *
 * Especificadores principales:
 *   %s  — String
 *   %d  — entero (int, long)
 *   %f  — decimal (double, float)
 *   %.2f — decimal con 2 cifras
 *   %n  — salto de linea (multiplataforma)
 *   %-10s — alineado a la izquierda en 10 caracteres
 *   %10s  — alineado a la derecha en 10 caracteres
 *   %05d  — relleno con ceros
 */
public class Ejercicio07Formato {

    public static void main(String[] args) {

        // String.format — crea el String sin imprimirlo
        String nombre = "Ana";
        int edad = 25;
        double nota = 8.75;

        String linea = String.format("Alumno: %-10s | Edad: %3d | Nota: %.2f", nombre, edad, nota);
        System.out.println(linea);

        // printf — imprime directamente
        System.out.printf("Pi con 5 decimales: %.5f%n", Math.PI);
        System.out.printf("Numero con ceros:   %08d%n", 42);
        System.out.printf("Hexadecimal:        %x%n", 255); // ff
        System.out.printf("Cientifico:         %e%n", 123456.789);

        // Tabla formateada con String.format
        System.out.println("\n=== Informe de ventas ===");
        System.out.printf("%-15s %10s %10s %10s%n", "Producto", "Precio", "Cantidad", "Total");
        System.out.println("-".repeat(50));

        Object[][] productos = {
            {"Laptop",     999.99, 3},
            {"Teclado",     49.95, 10},
            {"Monitor",    299.00, 5},
            {"Raton",       19.99, 15}
        };

        double totalGeneral = 0;
        for (Object[] p : productos) {
            String prod = (String) p[0];
            double precio = (double) p[1];
            int cantidad = (int) p[2];
            double total = precio * cantidad;
            totalGeneral += total;
            System.out.printf("%-15s %10.2f %10d %10.2f%n", prod, precio, cantidad, total);
        }

        System.out.println("-".repeat(50));
        System.out.printf("%-15s %10s %10s %10.2f%n", "TOTAL", "", "", totalGeneral);

        // formatted() — Java 15+ equivalente a String.format con instancia
        String msg = "El resultado es %d".formatted(42);
        System.out.println("\n" + msg);
    }
}

package Tema07Clases.ejercicio04Conversor;
/**
 * Tema 7: [Clases]
 * <p>
 * Ejercicio 04: [Creación de un conversor de varios tipos de medidas]
 *
 * @author kabadev
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                    🌍 Bienvenido al sistema de Conversión
                    
                    Elige una opción:
                    
                    1. Conversor de Divisas (euros ↔ libras)
                    2. Conversor de Pesos (gramos, kg, lb, oz)
                    3. Conversor de Distancias (millas náuticas ↔ metros y kilómetros)
                    4. Conversor de Temperaturas (Celsius, Fahrenheit, Kelvin)
                    5. Conversor de Unidades de Datos(b, MB, MiB, GB, GiB).
                    0. Salir
                    
                    👉 Opción:
                    """);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("🔢 Introduce el tipo de cambio euro ↔ libra (por ejemplo, 0.85): ");
                    double tipoDivisas = sc.nextDouble();

                    double euros = 100.00;
                    double libras = 100.00;

                    ConversorDivisas[] conversores = {
                            new ConversorDivisas(),
                            new ConversorDivisas(tipoDivisas)
                    };

                    String[] etiquetas = {
                            "tipo de cambio por defecto",
                            "tipo de cambio personalizado"
                    };

                    for (int i = 0; i < conversores.length; i++) {
                        ConversorDivisas conv = conversores[i];
                        System.out.println("\n📊 --- Conversor con " + etiquetas[i] + " (" + conv.getTipoCambio() + ") ---");
                        System.out.printf("💶 %.2f euros = %.2f libras%n", euros, conv.eurosToLibras(euros));
                        System.out.printf("💷 %.2f libras = %.2f euros%n", libras, conv.librasToEuros(libras));
                    }
                }

                case 2 -> {
                    System.out.print("📥 Introduce la cantidad de peso: ");
                    double cantidad = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("📏 Introduce la unidad (gr, kg, lb, oz): ");
                    String unidad = sc.nextLine().trim().toLowerCase();

                    if (!unidad.matches("gr|kg|lb|oz")) {
                        System.out.println("❌ Unidad no válida. Debe ser: gr, kg, lb u oz.");
                        break;
                    }

                    ConversorPesos conversor = new ConversorPesos(cantidad, unidad);

                    System.out.println("\n📦 --- Conversión de Pesos ---");
                    System.out.printf("📌 Gramos: %.2f gr%n", conversor.getGramos());
                    System.out.printf("📌 Kilogramos: %.2f kg%n", conversor.getPeso());
                    System.out.printf("📌 Libras: %.2f lb%n", conversor.getLibras());
                    System.out.printf("📌 Onzas: %.2f oz%n", conversor.getOnzas());
                }

                case 3 -> {
                    System.out.print("🚗 Introduce una cantidad en millas náuticas: ");
                    double millas = sc.nextDouble();

                    ConversorDistancia d = new ConversorDistancia();

                    double metros = d.millasAMetros(millas);
                    double km = d.millasAKilometros(millas);

                    System.out.println("\n📏 --- Conversión de Distancia ---");
                    System.out.printf("🌊 %.2f millas = %.2f metros%n", millas, metros);
                    System.out.printf("🌍 %.2f millas = %.2f kilómetros%n", millas, km);
                }

                case 4 -> {
                    System.out.println("🌡️ Conversor de Temperaturas");
                    System.out.println("Elige unidad de entrada:");
                    System.out.println("1. Celsius (°C)");
                    System.out.println("2. Fahrenheit (°F)");
                    System.out.println("3. Kelvin (K)");
                    System.out.print("👉 Opción: ");
                    int opcionTemp = sc.nextInt();

                    System.out.print("🔢 Introduce la temperatura: ");
                    double valor = sc.nextDouble();

                    ConversorTemperatura temp = new ConversorTemperatura();

                    switch (opcionTemp) {
                        case 1 -> {
                            temp.setCelsius(valor);
                            System.out.printf("🌡️ %.2f °C = %.2f °F%n", valor, temp.celsiusToFahrenheit());
                            System.out.printf("🌡️ %.2f °C = %.2f K%n", valor, temp.celsiusToKelvin());
                        }
                        case 2 -> {
                            temp.setFahrenheit(valor);
                            System.out.printf("🌡️ %.2f °F = %.2f °C%n", valor, temp.fahrenheitToCelsius());
                            System.out.printf("🌡️ %.2f °F = %.2f K%n", valor, temp.fahrenheitToKelvin());
                        }
                        case 3 -> {
                            temp.setKelvin(valor);
                            System.out.printf("🌡️ %.2f K = %.2f °C%n", valor, temp.kelvinToCelsius());
                            System.out.printf("🌡️ %.2f K = %.2f °F%n", valor, temp.kelvinToFahrenheit());
                        }
                        default -> System.out.println("❌ Opción de unidad no válida.");
                    }
                }
                case 5 -> {
                    System.out.print("💾 Introduce una cantidad de datos en bytes: ");
                    int cantidad = sc.nextInt();

                    ConversorDatos datos = new ConversorDatos(cantidad);

                    System.out.println("""
                            📦 Elige unidad a la que deseas convertir:
                            1. Bits (b)
                            2. Megabytes (MB)
                            3. Mebibytes (MiB)
                            4. Gigabytes (GB)
                            5. Gibibytes (GiB)
                            6. Mostrar todo
                            """);
                    System.out.print("👉 Opción: ");
                    int tipoUnidad = sc.nextInt();

                    switch (tipoUnidad) {
                        case 1 -> System.out.printf("🔢 %d bytes = %.2f bits%n", cantidad, datos.getBits());
                        case 2 -> System.out.printf("📁 %d bytes = %.4f MB%n", cantidad, datos.getMB());
                        case 3 -> System.out.printf("📁 %d bytes = %.4f MiB%n", cantidad, datos.getMiB());
                        case 4 -> System.out.printf("💽 %d bytes = %.6f GB%n", cantidad, datos.getGB());
                        case 5 -> System.out.printf("💽 %d bytes = %.6f GiB%n", cantidad, datos.getGiB());
                        case 6 -> {
                            System.out.printf("🔢 %d bytes = %.2f bits%n", cantidad, datos.getBits());
                            System.out.printf("📁 %.4f MB%n", datos.getMB());
                            System.out.printf("📁 %.4f MiB%n", datos.getMiB());
                            System.out.printf("💽 %.6f GB%n", datos.getGB());
                            System.out.printf("💽 %.6f GiB%n", datos.getGiB());
                        }
                        default -> System.out.println("❌ Opción no válida.");
                    }
                }


                case 0 -> System.out.println("👋 ¡Gracias por usar el conversor!");
                default -> System.out.println("❌ Opción no válida. Inténtalo de nuevo.");
            }

            if (opcion != 0) {
                System.out.println("\nPresiona Enter para continuar...");
                sc.nextLine(); // Limpiar buffer
                sc.nextLine(); // Esperar Enter
            }

        } while (opcion != 0);

        sc.close();
        System.out.println("\n✅ Conversión finalizada.");
    }
}

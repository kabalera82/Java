package Tema14Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Ejercicio 06 - Optional
 *
 * Optional es un contenedor que puede contener un valor o estar vacio.
 * Evita el NullPointerException de forma explicita y elegante.
 *
 * Regla de oro: nunca llames a get() sin comprobar isPresent() antes,
 * o usa orElse/orElseGet/orElseThrow en su lugar.
 */
public class Ejercicio06Optional {

    public static Optional<String> buscarNombre(List<String> lista, String prefijo) {
        return lista.stream()
                    .filter(n -> n.startsWith(prefijo))
                    .findFirst();
    }

    public static Optional<Integer> dividir(int a, int b) {
        if (b == 0) return Optional.empty();
        return Optional.of(a / b);
    }

    public static void main(String[] args) {

        // Crear Optional
        Optional<String> conValor = Optional.of("Hola");
        Optional<String> vacio = Optional.empty();
        Optional<String> nullable = Optional.ofNullable(null); // safe — no lanza NPE

        // Verificar y obtener
        System.out.println("=== isPresent / isEmpty ===");
        System.out.println("conValor.isPresent(): " + conValor.isPresent());
        System.out.println("vacio.isEmpty():      " + vacio.isEmpty()); // Java 11+

        // orElse — valor por defecto si vacio
        System.out.println("\n=== orElse ===");
        String resultado = vacio.orElse("valor por defecto");
        System.out.println("vacio.orElse:     " + resultado);
        System.out.println("conValor.orElse:  " + conValor.orElse("no se usa"));

        // orElseGet — valor por defecto calculado (lazy)
        String calculado = vacio.orElseGet(() -> "calculado en el momento");
        System.out.println("\norElseGet: " + calculado);

        // orElseThrow — lanzar excepcion si vacio
        try {
            vacio.orElseThrow(() -> new RuntimeException("No se encontro el valor"));
        } catch (RuntimeException e) {
            System.out.println("\norElseThrow: " + e.getMessage());
        }

        // ifPresent — ejecutar solo si hay valor
        conValor.ifPresent(v -> System.out.println("\nifPresent: " + v));

        // map — transformar si hay valor
        Optional<Integer> longitud = conValor.map(String::length);
        System.out.println("map length: " + longitud.orElse(0));

        // Uso real con Stream
        List<String> nombres = Arrays.asList("Ana", "Marcos", "Luis", "Valentina");

        System.out.println("\n=== buscarNombre ===");
        Optional<String> encontrado = buscarNombre(nombres, "M");
        encontrado.ifPresentOrElse(
            n -> System.out.println("Encontrado: " + n),
            ()  -> System.out.println("No encontrado")
        );

        Optional<String> noEncontrado = buscarNombre(nombres, "Z");
        noEncontrado.ifPresentOrElse(
            n -> System.out.println("Encontrado: " + n),
            ()  -> System.out.println("No encontrado (prefijo 'Z')")
        );

        // Division segura
        System.out.println("\n=== Division con Optional ===");
        dividir(10, 2).ifPresent(r -> System.out.println("10/2 = " + r));
        System.out.println("10/0 = " + dividir(10, 0).orElse(-1));
    }
}

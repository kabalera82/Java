package Tema11Colecciones;

import java.util.List;
import java.util.Map;

public class ListaPruebas {

    public static final List<Map.Entry<String, Double>> DATOS_CLAVE_VALOR_EXTENSOS = List.of(
            // Bloque A: Valores estándar
            Map.entry("Código A", 10.55),
            Map.entry("Código B", 20.00),
            Map.entry("Código C", 30.15),

            // Bloque B: Conflicto de claves (la segunda sobrescribe a la primera)
            Map.entry("Código A", 99.99),

            // Bloque C: Casos de borde de valores
            Map.entry("Cero Valor", 0.0),
            Map.entry("Negativo Valor", -15.50),

            // Bloque D: Nulos
            Map.entry("Clave Nula Valor", null), // Valor Nulo
            Map.entry(null, 500.00),             // Clave Nula (HashMap solo permite una)

            // Bloque E: Claves similares (para probar la sensibilidad a mayúsculas/minúsculas)
            Map.entry("CLAVE_S", 1.0),
            Map.entry("clave_s", 2.0),

            // Bloque F: Claves largas
            Map.entry("Una Clave Muy Larga Para Probar El Hash", 123.45),

            // Bloque G: Claves con espacio/vacía
            Map.entry("", 77.7),
            Map.entry(" ", 88.8)
    );
}

/*
Ejemplo de uso:

import java.util.HashMap;s
import java.util.Map;

Map<String, Double> miMapa = new HashMap<>();
for (Map.Entry<String, Double> entry : ListaPruebas.DATOS_CLAVE_VALOR_EXTENSOS) {
    miMapa.put(entry.getKey(), entry.getValue());
}

// miMapa.get("Código A") resultará en 99.99
// miMapa.containsKey(null) resultará en true (si es HashMap)
*/

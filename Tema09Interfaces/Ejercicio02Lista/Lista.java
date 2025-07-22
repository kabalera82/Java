package Tema09Interfaces.Ejercicio02Lista;

import java.util.Arrays;

public class Lista implements Cola {
    private Integer[] elementos;
    private int tamano;

    // Constructor
    public Lista() {
        elementos = new Integer[0];
        tamano = 0;
    }

    // Encolar (añadir al final)
    public void encolar(Integer numero) {
        elementos = Arrays.copyOf(elementos, tamano + 1);
        elementos[tamano] = numero;
        tamano++;
    }

    // Desencolar (sacar del principio)
    public Integer desencolar() {
        if (tamano == 0) {
            return null;
        }
        Integer primero = elementos[0];
        for (int i = 0; i < tamano - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamano--;
        elementos = Arrays.copyOf(elementos, tamano);
        return primero;
    }

    // Saber si está vacía
    public boolean estaVacia() {
        return tamano == 0;
    }

    // Mostrar los elementos actuales (opcional)
    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < tamano; i++) {
            System.out.print(elementos[i]);
            if (i < tamano - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

package Tema04_02VarArgs;

import Tema04_02VarArgs.utils.*;

public class Ejercicio04SobrecargaMetodos {

    public static void main(String[] args) {

        Utilidades2 utilidades2 = new Utilidades2();
        utilidades2.calcular(1, 1.0, 1, 1);

        utilidades2.calcular(5);                         // Calcular v1
        utilidades2.calcular((short)5, 6, 7);           // Calcular v4
        utilidades2.calcular(5, 2.5, 7, 8, 9);    // Calcular v5
        utilidades2.calcular(1);                         // calcular(int a) → v1
        utilidades2.calcular(new int[]{1});                 // calcular(int... v) → v2
        utilidades2.calcular((short) 1, 2, 3);          // calcular(int a, int... v) → v3
    }
}

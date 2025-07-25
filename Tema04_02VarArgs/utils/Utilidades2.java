package Tema04_02VarArgs.utils;

public class Utilidades2 {

    public void calcular(int a){
        System.out.println("Calcular v1");
    }

    public void calcular(int... v){
        System.out.println("Calcular v2");
    }

    public void calcular(int a, int... v){
        System.out.println("Calcular v3");
    }

    public void calcular(short a, int... v){
        System.out.println("Calcular v4");
    }

    public void calcular(int a, double b, int... v){
        System.out.println("Calcular v5");
    }
}

package Tema04_01Metodos;

import java.util.Scanner;

public class Ejercicio33EstadisticaBasica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce 10 números:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int num4 = sc.nextInt();
        int num5 = sc.nextInt();
        int num6 = sc.nextInt();
        int num7 = sc.nextInt();
        int num8 = sc.nextInt();
        int num9 = sc.nextInt();
        int num10 = sc.nextInt();

        int suma = getSuma(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10);
        double media = suma / 10.0;
        int max = getMaximo(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10);
        int min = getMinimo(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10);
        double desviacion = getDesviacionTipica(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, media);
        double mediana = getMedianaManual(num1, num2, num3, num4, num5, num6, num7, num8, num9, num10);

        System.out.println("El resultado es:");
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Desviación típica: " + desviacion);
        System.out.println("Mediana (ordenada manualmente): " + mediana);
    }

    public static int getSuma(int n1, int n2, int n3, int n4, int n5,
                              int n6, int n7, int n8, int n9, int n10) {
        return n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10;
    }

    public static int getMaximo(int a, int b, int c, int d, int e,
                                int f, int g, int h, int i, int j) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        if (e > max) max = e;
        if (f > max) max = f;
        if (g > max) max = g;
        if (h > max) max = h;
        if (i > max) max = i;
        if (j > max) max = j;
        return max;
    }

    public static int getMinimo(int a, int b, int c, int d, int e,
                                int f, int g, int h, int i, int j) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        if (e < min) min = e;
        if (f < min) min = f;
        if (g < min) min = g;
        if (h < min) min = h;
        if (i < min) min = i;
        if (j < min) min = j;
        return min;
    }

    public static double getDesviacionTipica(int n1, int n2, int n3, int n4, int n5,
                                             int n6, int n7, int n8, int n9, int n10, double media) {
        double sumaCuadrados = 0;
        sumaCuadrados += Math.pow(n1 - media, 2);
        sumaCuadrados += Math.pow(n2 - media, 2);
        sumaCuadrados += Math.pow(n3 - media, 2);
        sumaCuadrados += Math.pow(n4 - media, 2);
        sumaCuadrados += Math.pow(n5 - media, 2);
        sumaCuadrados += Math.pow(n6 - media, 2);
        sumaCuadrados += Math.pow(n7 - media, 2);
        sumaCuadrados += Math.pow(n8 - media, 2);
        sumaCuadrados += Math.pow(n9 - media, 2);
        sumaCuadrados += Math.pow(n10 - media, 2);

        return Math.sqrt(sumaCuadrados / 10);
    }

    public static double getMedianaManual(int n1, int n2, int n3, int n4, int n5,
                                          int n6, int n7, int n8, int n9, int n10) {
        return (n5 + n6) / 2.0;
    }
}


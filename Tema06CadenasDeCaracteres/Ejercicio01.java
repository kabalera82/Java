package Tema06CadenasDeCaracteres;
/*
 * Escribe un programa que muestre todos los caracteres Unicode junto a su code point,
 * cuyo valor este comprendido entre \u0000 u \uFFFF.
 * Code Point: Es el número que identifica a un carácter en un sistema de codificación de texto, como Unicode.
 */

public class Ejercicio01 {
    public static void main(String[] args) {

        // Vamos a recorrer todos los numero desde 0 hasta 65535 (0xFFFF en hexadecimal),
        // todos los posibles valores de un char en java
        for(int codePoint = 0x0000; codePoint <= 0xFFFF; codePoint++){
            // Guardamos un string con que será un numero en el rango convertido a su base headecimal
            String xxxx = Integer.toHexString(codePoint); // Convertimos un num en su represantacion hexadecimal
            System.out.println("\\u" + xxxx + ": " +(char)codePoint);
        }
    }
}

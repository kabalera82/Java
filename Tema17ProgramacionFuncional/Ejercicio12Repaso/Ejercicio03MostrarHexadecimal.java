package Tema17ProgramacionFuncional.Ejercicio12Repaso;

import org.w3c.dom.ls.LSOutput;

import java.util.stream.IntStream;

public class Ejercicio03MostrarHexadecimal {

    public static void main(String[] args) {
        IntStream
                .rangeClosed(0x0000, 0xFFFF)// Genera un rango con todos los numeros del 0 al 65535
                .mapToObj(codePoint -> {
                    String xxxx = Integer.toHexString(codePoint);
                    return "\\u" + xxxx + ": " + (char) codePoint;//Para que imprima el formato unicode necesitamos 
                })
                .forEach(System.out::println); // Imprime cada línea
    }
}

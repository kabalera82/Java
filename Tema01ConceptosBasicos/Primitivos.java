package Tema01ConceptosBasicos;

public class Primitivos {

    // Tipos de datos primitivos en Java
    // Entero de 8 bits el rango de valore sin signo es de 0 a 255
    // byte = 8 bits
    byte numeroByteSinSigno = 0; // 0 a 255
    // Entero de 8 bits con signo, el rango de valores es de -128 a 127
    byte numeroByte = 100; // -128 a 127

    // short = 16 bits con signo, el rango de valores es de -32,768 a 32,767
    short numeroShort = 1000; // -32,768 a 32,767

    // int = 32 bits con signo, el rango de valores es de -2,147,483,648 a 2,147,483,647
    int numeroInt = 100000; // -2,147,483,648 a 2,147,483,647

    // long = 64 bits con signo, el rango de valores es de -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
    long numeroLong = 10000000000L; // -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807

    //Overflow: Cuando el valor excede el rango del tipo de dato


    public static void main(String[] args) {
        int numero = 10;
        double decimal = 5.5;
        char letra = 'A';
        boolean esVerdadero = true;

        System.out.println("int: " + numero);
        System.out.println("double: " + decimal);
        System.out.println("char: " + letra);
        System.out.println("boolean: " + esVerdadero);
    }
}
package Tema04_02VarArgs.utils;


public class Utilidades {

    // Este método sirve para un argumento ya declarado -------------------------------------------------------------
    public void calcular (int... v) {
        int suma = 0;
        System.out.println("numero de argumentos: "+ v.length); //vemos que tienes los metodos de una matriz
        for(int i= 0; i<v.length;i++){
            System.out.println("Numero a sumar: " +v[i]);
            suma += v[i];
        }
        System.out.println("Suma total de todos los valores: " + suma);
    }

    // Este método deberemos declarar una matriz y esa matriz pasarla como argumento ---------------------------------
    public void calcular2(int [] v){
        int suma = 0;

        //recorremos la matriz
        System.out.println("Numero de argumentos: " + v.length);
        for(int i = 0; i<v.length;i++){
            System.out.println("Numero a sumar: " + v[i]);
            suma += v[i];
        }
        System.out.println("Suma total de todos los numeros: " + suma);
    }

    // Argumentos Variables ------------------------------------------------------------------------------------
    public void calcular3 (int a, int b, int... v){ // se debe poner al final ...v
        int suma = 0;

        //recorremos la matriz
        System.out.println("Numero de argumentos: " + v.length);
        for(int i = 0; i<v.length;i++){
            System.out.println("Numero a sumar: " + v[i]);
            suma += v[i];
        }

        System.out.println("Valor de a: " + a);
        suma +=a;
        System.out.println("Valor de b: " + b);
        suma +=b;
        System.out.println("Suma total de todos los numeros: " + suma);

    }

    // Con Va -----------------------------------------------------------------------------------------------
    public void calcular4 (char a, int... v){ // se debe poner al final ...v

        switch (a){
            case 's':
                int suma = 0;
                System.out.println("Numero de argumentos: " + v.length);
                for(int i = 0; i<v.length;i++){
                    System.out.println("Numero a sumar: " + v[i]);
                    suma += v[i];
                }
                System.out.println("Suma total de todos los numeros: " + suma);
                break;
            case'r':
                int resta = 0;
                System.out.println("Numero e argumentos: " + v.length);
                for(int i = 0; i<v.length;i++){
                    System.out.println("Numero a sumar: " + v[i]);
                    resta -= v[i];
                }
                System.out.println("Resta total de todos los numeros: " + resta);
                break;
            default:
                System.out.println("Elige una opcion válida: ");
                throw new AssertionError();
        }



    }

}

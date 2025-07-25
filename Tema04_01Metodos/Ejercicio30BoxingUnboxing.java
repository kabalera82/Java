package Tema04_01Metodos;

public class Ejercicio30BoxingUnboxing {
    public static void main(String[] args) {

        //Declaramos un objeto de tipo Character
        Character chWrapped = 'a';

        // autoBoxing -----------------------------
        // obtendremos la clase a la que pertenece
        System.out.println(chWrapped.getClass());

        // autoUnboxing----------------------------
        char ch = chWrapped;
        // Se realiza una conversion de autoUnboxin obtenemos el tipo objeto en un primitivo
        System.out.println(ch);

        // Boxing ---------------------------------
        int numeroPrimitivo = 1000;
        //vamos a hacer una conversion
        Integer numeroObjeto = Integer.valueOf(numeroPrimitivo); //boxing
        System.out.println(numeroObjeto.getClass());
        System.out.println("" + numeroObjeto.intValue());

        // UnBoxing -------------------------------
        int numeroPrimitivo2 = numeroObjeto.intValue(); //unboxing
        System.out.println(numeroPrimitivo2);


    }
}

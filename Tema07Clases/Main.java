package Tema07Clases;

import static Tema07Clases.ejercicio01persona.Main.*;
import static Tema07Clases.ejercicio02coche.Main.*;
import static Tema07Clases.ejercicio03CuentaCorriente.Main.*;

/*
Esto es lo mismo que
import static Tema07Clases.ejercicio03CuentaCorriente.Main.cuenta0;
import static Tema07Clases.ejercicio03CuentaCorriente.Main.cuenta1;
*/
public class Main {

    public static final DDBBPersonCocheCCorriente ddbb00 = new DDBBPersonCocheCCorriente(Marcos, coche0, cuenta0);
    public static final DDBBPersonCocheCCorriente ddbb01 = new DDBBPersonCocheCCorriente(Maria, coche1, cuenta1);

    public static void main(String[] args) {
        System.out.println(ddbb00 + "\n" + ddbb01);
    }
}

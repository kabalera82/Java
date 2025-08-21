package Tema07Clases;

import Tema07Clases.ejercicio07personaSobrecarga.Deportista;

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


        Deportista d1 = new Deportista(Marcos, "Natación", true, "FED-1234");
        Deportista d2 = new Deportista(Maria, "Running", false, "FED-9999"); // no se guardará

        d1.showInfo();                   // Marcos practices Natación [Federated]
        d2.showInfo();                   // Maria practices Running [Not federated]

        d1.showInfo(true, true);         // Marcos practices Natación [Federated] | License: FED-1234
        d2.showInfo(true, true);


        //System.out.println(ddbb00 +"\n" + ddbb01 + d2);
    }
}

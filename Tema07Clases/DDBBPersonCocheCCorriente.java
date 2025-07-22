package Tema07Clases;

import Tema07Clases.ejercicio01persona.Persona;
import Tema07Clases.ejercicio02coche.Coche;
import Tema07Clases.ejercicio03CuentaCorriente.CuentaCorriente;


public class DDBBPersonCocheCCorriente {

    private static int contador = 0;
    private final int id;
    private Persona persona;
    private Coche coche;
    private CuentaCorriente cuentaCorriente;


    public DDBBPersonCocheCCorriente(Persona persona, Coche coche, CuentaCorriente cuentaCorriente) {
        this.id = contador++;
        this.persona = persona;
        this.coche = coche;
        this.cuentaCorriente = cuentaCorriente;
    }

    @Override
    public String toString() {
        return "\n" +
                "Datos Cliente:\n" +
                "ID: " + id + "\n" +
                "Id cliente: \n" + id + "\n" +
                "Personales: " + persona + "\n" +
                "Vehículo: " + coche + "\n" +
                "Bancarios: " + cuentaCorriente +
                "\n";
    }

}

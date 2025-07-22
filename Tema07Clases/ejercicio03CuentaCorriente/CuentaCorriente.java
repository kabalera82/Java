package Tema07Clases.ejercicio03CuentaCorriente;

/**
 * Tema 7: [Clases]
 * <p>
 * Ejercicio 03: [Creación de la Cuenta Corriente]
 *
 * @author kabadev
 */

public class CuentaCorriente {

    private static int contador = 0;
    private final int idCuenta;
    private int numeroCuenta;
    private Double saldo;

    private CuentaCorriente() {
        this.idCuenta = ++contador;
    }

    public CuentaCorriente(int numeroCuenta, Double saldo) {
        this();
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return "ID cuenta Corriente: " + idCuenta + '\'' +
                ", numeroCuenta: " + numeroCuenta + '\'' +
                ", saldo: " + saldo + '\'';
    }


}

/**
 * Ejercicio 04 - excepciones personalizadas
 *
 * Puedes crear tus propias excepciones extendiendo RuntimeException
 * (no checked — no obliga al llamador a capturarla) o Exception
 * (checked — obliga al llamador a usar try-catch o declarar throws).
 *
 * Convencion: el nombre siempre termina en "Exception".
 */

// Excepcion personalizada (unchecked — extiende RuntimeException)
class SaldoInsuficienteException extends RuntimeException {

    private final double importe;

    public SaldoInsuficienteException(double importe, double saldo) {
        super("Saldo insuficiente. Intentaste retirar " + importe +
              " pero solo tienes " + saldo);
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }
}

// Excepcion personalizada (unchecked)
class EdadInvalidaException extends RuntimeException {
    public EdadInvalidaException(int edad) {
        super("Edad invalida: " + edad + ". Debe estar entre 0 y 120.");
    }
}

class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirar(double importe) {
        if (importe > saldo) {
            throw new SaldoInsuficienteException(importe, saldo);
        }
        saldo -= importe;
        System.out.println("Retirado: " + importe + " | Saldo restante: " + saldo);
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException(edad);
        }
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " anos)";
    }
}

public class Ejercicio04ExcepcionPersonalizada {

    public static void main(String[] args) {

        // SaldoInsuficienteException
        CuentaBancaria cuenta = new CuentaBancaria(100.0);
        try {
            cuenta.retirar(50.0);   // ok
            cuenta.retirar(80.0);   // lanza SaldoInsuficienteException
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excepcion: " + e.getMessage());
            System.out.println("Importe solicitado: " + e.getImporte());
        }

        System.out.println();

        // EdadInvalidaException
        try {
            Persona p1 = new Persona("Ana", 25);
            System.out.println("Persona creada: " + p1);

            Persona p2 = new Persona("Bob", -5); // lanza EdadInvalidaException
            System.out.println("Persona creada: " + p2);
        } catch (EdadInvalidaException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }
}

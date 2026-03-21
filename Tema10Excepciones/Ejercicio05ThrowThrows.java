/**
 * Ejercicio 05 - throw y throws
 *
 * throw  — lanza una excepcion en un punto concreto del codigo.
 * throws — declara que un metodo PUEDE lanzar una excepcion checked.
 *           Obliga al llamador a usar try-catch o propagar con throws.
 *
 * Checked   → extiende Exception (no RuntimeException)
 *             → el compilador obliga a tratarla
 * Unchecked → extiende RuntimeException
 *             → el compilador no obliga a tratarla
 */

// Checked exception (extiende Exception, no RuntimeException)
class PasswordDemasiadoCortoException extends Exception {
    public PasswordDemasiadoCortoException(int longitud) {
        super("La contrasena tiene " + longitud + " caracteres. Minimo 8.");
    }
}

class ValidadorPassword {

    // throws declara que este metodo puede lanzar la excepcion checked
    public static void validar(String password) throws PasswordDemasiadoCortoException {
        if (password == null || password.length() < 8) {
            throw new PasswordDemasiadoCortoException(
                password == null ? 0 : password.length()
            );
        }
        System.out.println("Password valida: " + password);
    }
}

class Calculadora {

    // throws con excepcion unchecked (RuntimeException) — opcional declararlo
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    // Propagar la excepcion checked al llamador con throws
    public static void procesarPassword(String pwd) throws PasswordDemasiadoCortoException {
        ValidadorPassword.validar(pwd); // si lanzara, lo propagamos
    }
}

public class Ejercicio05ThrowThrows {

    public static void main(String[] args) {

        // Checked exception — OBLIGATORIO usar try-catch o declarar throws en main
        try {
            ValidadorPassword.validar("abc");        // lanza excepcion
        } catch (PasswordDemasiadoCortoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            ValidadorPassword.validar("contrasena_segura"); // ok
        } catch (PasswordDemasiadoCortoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Unchecked exception — try-catch opcional
        try {
            double resultado = Calculadora.dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico: " + e.getMessage());
        }

        System.out.println("Division 10/4 = " + Calculadora.dividir(10, 4)); // ok, sin try-catch

        System.out.println();

        // Propagacion de excepcion checked
        try {
            Calculadora.procesarPassword("1234");
        } catch (PasswordDemasiadoCortoException e) {
            System.out.println("Propagada: " + e.getMessage());
        }
    }
}
